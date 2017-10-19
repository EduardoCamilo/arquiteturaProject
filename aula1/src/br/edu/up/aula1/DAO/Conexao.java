package br.edu.up.aula1.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("aula1");
	
	public static EntityManager getInstance() {
		return emf.createEntityManager();
	}

}
