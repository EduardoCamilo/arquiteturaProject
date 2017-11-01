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

import br.edu.up.aula1.DAO.ProdutoDAO;
import br.edu.up.aula1.entidade.Produto;
import br.edu.up.aula1.service.ProdutoService;
import br.edu.up.aula1.service.ServiceException;

public class ProdutoRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Produto> listarProdutos() {
		List<Produto> produtos = new ProdutoDAO().listar();
		return new ArrayList<>(produtos);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarProduto(Produto produtos) {
		try {
			new ProdutoService().salvar(produtos);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarProduto(Produto produtos) {
		try {
			new ProdutoService().excluir(produtos);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarProduto(Produto produtos) {
		try {
			new ProdutoService().alterar(produtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
