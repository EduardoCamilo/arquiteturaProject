package br.edu.up.aula1.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.up.aula1.entidade.Cliente;
import br.edu.up.aula1.entidade.Funcionario;

public class FuncionarioDAO implements Dao<Funcionario> {

	public void salvar(Funcionario f) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}

	
	public void excluir(Funcionario f) {
		
		
	}

	
	public void alterar(Funcionario f) {
		
		
	}

	
	public List<Funcionario> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Funcionario");
		return q.getResultList();
	}

	
	public Funcionario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
