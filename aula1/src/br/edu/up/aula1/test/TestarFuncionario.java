package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.aula1.DAO.FuncionarioDAO;
import br.edu.up.aula1.entidade.Funcionario;

public class TestarFuncionario {

	@Test
	public void cadastrarFuncionario() {
		
		Funcionario f = new Funcionario();
		
		f.setId(null);
		f.setNome("Benyton");
		f.setMatricula("e001");
		f.setCargo("Estoquista");
		f.setHorario("matinal");
		
		new FuncionarioDAO().salvar(f);
		
		assertEquals(true, f.getId() != null);
	}
	
	@Test
	public void listarFuncionario() {
		
		List<Funcionario> funcionarios = new FuncionarioDAO().listar();
		
		assertEquals(true, funcionarios.size()>0);
	}
}
