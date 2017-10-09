package br.edu.up.aula1.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.aula1.entidade.Cliente;

public class ClienteDAO implements Dao<Cliente>{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula1");

	public void salvar(Cliente c) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	public void excluir(Cliente c) {
		
	}
	
	public void alterar(Cliente c) {
		
	}
	
	public List<Cliente> listar(){
		return null;
	}
	
	public Cliente buscarPorId(Integer id) {
		return null;
	}
}
