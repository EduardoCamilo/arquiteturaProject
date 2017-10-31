package br.edu.up.aula1.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.up.aula1.DAO.ClienteDAO;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.service.ClienteService;
import br.edu.up.aula1.service.ServiceException;

public class FuncionarioRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> listarClientes() {
		List<Cliente> clientes = new ClienteDAO().listar();
		return new ArrayList<>(clientes);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarCliente(Cliente cliente) {
		try {
			new ClienteService().salvar(cliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarCliente(Cliente cliente) {
		try {
			new ClienteService().excluir(cliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarCliente(Cliente cliente) {
		try {
			new ClienteService().alterar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
