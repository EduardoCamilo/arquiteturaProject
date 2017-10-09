package br.edu.up.aula1.DAO;

import java.util.List;

import br.edu.up.aula1.entidade.Cliente;

public interface Dao<T> {

	public void salvar(T t);
	
	public void excluir(T t);
	
	public void alterar(T t);
	
	public List<Cliente> listar();
	
	public T buscarPorId(Integer id);
}
