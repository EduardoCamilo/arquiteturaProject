package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.DAO.ProdutoDAO;
import br.edu.up.aula1.entidade.Produto;
import br.edu.up.aula1.service.ProdutoService;
import br.edu.up.aula1.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarProduto {

	static Produto p = new Produto();
	
	@Test
	public void testAcadastrarProduto() {
		
		p.setId(null);
		p.setNome("Disco traseiro");
		p.setDescricao("Disco de freios traseiro");
		p.setValorBruto(34.9);
		p.setValorDeVenda(49.9);
		p.setMargemSeguranca(5);
		
		try {
			new ProdutoService().salvar(p);
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, p.getId() != null);
	}
	
	@Test
	public void testClistarProduto() {
		
		List<Produto> produtos = new ProdutoDAO().listar();
		
		assertEquals(true, produtos.size()>0);
	}
	
	@Test
	public void testDexcluirCliente() {
				
		try {
			new ProdutoService().excluir(p);
			
			p = FactoryDao.createProdutoDao().buscarPorId(p.getId());
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, p == null);
	}
	
	@Test
	public void testBalterarCliente() {
				
		p.setNome("Kit rolamento traseiro");
		p.setDescricao("Kit de rolamento traseiro");
		p.setValorBruto(54.9);
		p.setValorDeVenda(69.9);
		p.setMargemSeguranca(5);
		
		try {
			new ProdutoService().alterar(p);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, p.getId() != null);
	}
}
