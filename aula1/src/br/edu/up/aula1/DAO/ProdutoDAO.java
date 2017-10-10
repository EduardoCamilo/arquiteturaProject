package br.edu.up.aula1.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.up.aula1.entidade.Produto;

public class ProdutoDAO implements Dao<Produto> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula1");
	
	@Override
	public void salvar(Produto p) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	@Override
	public void excluir(Produto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Produto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Produto");
		return q.getResultList();
	}

	@Override
	public Produto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
