package br.com.breno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (CODIGO, NOME) VALUES (?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCodigo());
            stmt.setString(2, cliente.getNome());
            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<Cliente> verTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getString("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return clientes;
    }
}
