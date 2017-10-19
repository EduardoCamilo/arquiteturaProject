package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.aula1.DAO.FuncionarioDAO;
import br.edu.up.aula1.DAO.ProdutoDAO;
import br.edu.up.aula1.entidade.Funcionario;
import br.edu.up.aula1.entidade.Produto;
import br.edu.up.aula1.service.ProdutoService;
import br.edu.up.aula1.service.ServiceException;

public class TestarProduto {

	@Test
	public void cadastrarProduto() {
		
		Produto p = new Produto();
		
		p.setId(null);
		p.setNome("Fluído de freio");
		p.setDescricao("Fluído para freios");
		p.setValorBruto(9.9);
		p.setValorDeVenda(14.9);
		p.setMargemSeguranca(5);
		
		try {
			new ProdutoService().salvar(p);
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, p.getId() != null);
	}
	
	public void listarProduto() {
		
		List<Produto> produtos = new ProdutoDAO().listar();
		
		assertEquals(true, produtos.size()>0);
	}
}
