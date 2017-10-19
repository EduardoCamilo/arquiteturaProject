package br.edu.up.aula1.DAO;

import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Funcionario;
import br.edu.up.aula1.entidade.Produto;

public class FactoryDao {
	
	public static Dao<Cliente> createClienteDao() {
		return new ClienteDAO();
	}
	
	public static Dao<Funcionario> createFuncionarioDao() {
		return new FuncionarioDAO();
	}
	
	public static Dao<Produto> createProdutoDao() {
		return new ProdutoDAO();
	}

}