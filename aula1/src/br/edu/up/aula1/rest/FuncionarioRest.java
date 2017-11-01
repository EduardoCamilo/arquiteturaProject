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

import br.edu.up.aula1.DAO.FuncionarioDAO;
import br.edu.up.aula1.entidade.Funcionario;
import br.edu.up.aula1.service.FuncionarioService;
import br.edu.up.aula1.service.ServiceException;

public class FuncionarioRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Funcionario> listarFuncionarios() {
		List<Funcionario> funcionarios = new FuncionarioDAO().listar();
		return new ArrayList<>(funcionarios);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarFuncionario(Funcionario funcionario) {
		try {
			new FuncionarioService().salvar(funcionario);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarFuncionario(Funcionario funcionario) {
		try {
			new FuncionarioService().excluir(funcionario);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarFuncionario(Funcionario funcionario) {
		try {
			new FuncionarioService().alterar(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
