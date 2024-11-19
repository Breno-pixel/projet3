package br.com.breno;


import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Cadastrando cliente
        Cliente cliente = new Cliente();
        cliente.setCodigo("C001");
        cliente.setNome("João Silva");
        clienteDAO.cadastrar(cliente);

        // Cadastrando produto
        Produto produto = new Produto();
        produto.setCodigo("P001");
        produto.setDescricao("Notebook");
        produto.setPreco(3500.00);
        produtoDAO.cadastrar(produto);

        // Ver todos os clientes
        List<Cliente> clientes = clienteDAO.verTodos();
        clientes.forEach(c -> System.out.println(c.getCodigo() + " - " + c.getNome()));

        // Ver todos os produtos
        List<Produto> produtos = produtoDAO.verTodos();
        produtos.forEach(p -> System.out.println(p.getCodigo() + " - " + p.getDescricao() + " - R$" + p.getPreco()));
    }
}
