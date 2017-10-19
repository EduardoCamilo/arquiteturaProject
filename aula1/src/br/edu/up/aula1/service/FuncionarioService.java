package br.edu.up.aula1.service;

import br.edu.up.aula1.DAO.Dao;
import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Funcionario;

public class FuncionarioService {

	public void salvar(Funcionario f) throws ServiceException {
		
		if (f.getNome() == null || f.getNome().equals("")) {
			
			throw new 
			ServiceException("ERR01 - O nome precisa ser preenchido.");
		}
		
		Dao<Funcionario> funcionarioDao = FactoryDao.createFuncionarioDao();
		funcionarioDao.salvar(f);
	}
	
	public void alterar(Funcionario f) throws ServiceException {
		
		Dao<Funcionario> funcionarioDao = FactoryDao.createFuncionarioDao();
		funcionarioDao.alterar(f);
		
		
	}
	
}
