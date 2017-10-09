package br.edu.up.aula1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.up.aula1.DAO.ClienteDAO;
import br.edu.up.aula1.entidade.Cliente;

public class TestarCliente {

	@Test
	public void cadastrarCliente() {
		
		Cliente c = new Cliente();
		
		c.setId(null);
		c.setNome("Eduardo");
		
		new ClienteDAO().salvar(c);
		
		assertEquals(true, c.getId() != null);
	}
}
