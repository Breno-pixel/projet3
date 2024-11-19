package br.com.breno;


public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (CODIGO, DESCRICAO, PRECO) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getCodigo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
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
    public List<Produto> verTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setPreco(rs.getDouble("PRECO"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return produtos;
    }
}

