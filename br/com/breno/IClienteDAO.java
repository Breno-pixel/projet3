
public interface IClienteDAO {
    Integer cadastrar(Cliente cliente) throws Exception;

    List<Cliente> verTodos() throws Exception;
}
