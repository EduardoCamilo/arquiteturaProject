package br.edu.up.aula1.service;

import br.edu.up.aula1.DAO.Dao;
import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Produto;

public class ProdutoService {
	
	public void salvar(Produto p) throws ServiceException {
		
		if (p.getNome() == null || p.getNome().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O nome precisa ser preenchido.");
		}
		
		Dao<Produto> produtoDao = FactoryDao.createProdutoDao();
		produtoDao.salvar(p);
	}
	
	public void alterar(Produto p) throws ServiceException {
		
		Dao<Produto> produtoDao = FactoryDao.createProdutoDao();
		produtoDao.alterar(p);
		
		
	}
	
	public void excluir(Produto p) throws ServiceException {
		
		Dao<Produto> produtoDao = FactoryDao.createProdutoDao();
		produtoDao.excluir(p);
		
	}
}
