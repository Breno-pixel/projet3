package br.com.breno;


public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws Exception;

    List<Produto> verTodos() throws Exception;
}
