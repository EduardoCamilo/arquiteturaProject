package br.edu.up.aula1.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.up.aula1.entidade.Produto;

public class ProdutoDAO implements Dao<Produto> {
	
	public void salvar(Produto p) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void excluir(Produto p) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}

	public void alterar(Produto p) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

	public List<Produto> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Produto");
		return q.getResultList();
	}

	
	public Produto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
