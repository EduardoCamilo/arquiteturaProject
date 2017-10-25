package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.aula1.DAO.ClienteDAO;
import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.service.ClienteService;
import br.edu.up.aula1.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarCliente {

	static Cliente c = new Cliente();
	
	@Test
	public void TestAcadastrarCliente() {
		
		c.setId(null);
		c.setNome("Luana");
		
		try {
			new ClienteService().salvar(c);
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, c.getId() != null);
	}
	
	@Test
	public void testClistarClientes() {
		
		List<Cliente> clientes = new ClienteDAO().listar();
		
		assertEquals(true, clientes.size()>0);
	}
	
	@Test
	public void testDexcluirCliente() {
		
		try {
			new ClienteService().excluir(c);
			
			c = FactoryDao.createClienteDao().buscarPorId(c.getId());
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, c ==  null);
	}
	
	@Test
	public void testBalterarCliente() {
		
		c.setNome("Flavio");
		
		try {
			new ClienteService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, c.getId() != null);
	}
}
