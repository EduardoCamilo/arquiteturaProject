package br.edu.up.aula1.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Funcionario;

public class FuncionarioDAO implements Dao<Funcionario> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula1");
	
	@Override
	public void salvar(Funcionario f) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}

	@Override
	public void excluir(Funcionario f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Funcionario f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funcionario> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Funcionario");
		return q.getResultList();
	}

	@Override
	public Funcionario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
