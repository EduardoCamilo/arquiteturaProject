package br.edu.up.aula1.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.edu.up.aula1.DAO.ClienteDAO;
import br.edu.up.aula1.DAO.FuncionarioDAO;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Funcionario;

public class TestarCliente {

	@Test
	public void cadastrarCliente() {
		
		Cliente c = new Cliente();
		
		c.setId(null);
		c.setNome("Eduardo");
		
		new ClienteDAO().salvar(c);
		
		assertEquals(true, c.getId() != null);
	}
	
	public void listarClientes() {
		
		List<Cliente> clientes = new ClienteDAO().listar();
		
		assertEquals(true, clientes.size()>0);
	}
}
