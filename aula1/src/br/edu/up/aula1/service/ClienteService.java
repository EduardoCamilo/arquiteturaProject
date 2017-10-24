package br.edu.up.aula1.service;

import br.edu.up.aula1.DAO.Dao;
import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.entidade.Cliente;

public class ClienteService {
	
	public void salvar(Cliente c) throws ServiceException {
		
		if (c.getNome() == null || c.getNome().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O nome precisa ser preenchido.");
		}
		
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		clienteDao.salvar(c);
	}
	
	public void alterar(Cliente c) throws ServiceException {
		
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		clienteDao.alterar(c);
		
		
	}

	public void excluir(Cliente c) throws ServiceException {
		
		Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
		clienteDao.excluir(c);
		
	}

}