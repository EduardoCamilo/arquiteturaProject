package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.aula1.DAO.ClienteDAO;
import br.edu.up.aula1.DAO.Dao;
import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.service.ClienteService;
import br.edu.up.aula1.service.ServiceException;

public class TestarCliente {

	@Test
	public void cadastrarCliente() {
		
		Cliente c = new Cliente();
		
		c.setId(null);
		c.setNome("Eduardo");
		
		try {
			new ClienteService().salvar(c);
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
	
		
		assertEquals(true, c.getId() != null);
	}
	
	@Test
	public void listarClientes() {
		
		List<Cliente> clientes = new ClienteDAO().listar();
		
		assertEquals(true, clientes.size()>0);
	}
}
