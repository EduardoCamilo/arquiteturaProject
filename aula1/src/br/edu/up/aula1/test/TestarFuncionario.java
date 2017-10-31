package br.edu.up.aula1.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.aula1.DAO.FactoryDao;
import br.edu.up.aula1.DAO.FuncionarioDAO;
import br.edu.up.aula1.entidade.Funcionario;
import br.edu.up.aula1.service.FuncionarioService;
import br.edu.up.aula1.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarFuncionario {

	static Funcionario f = new Funcionario();
	
	@Test
	public void testAcadastrarFuncionario() {
		
		f.setId(null);
		f.setNome("Adriane");
		f.setMatricula("e007");
		f.setCargo("Caixa");
		f.setHorario("matinal");
		
		try {
			new FuncionarioService().salvar(f);
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, f.getId() != null);
	}
	
	@Test
	public void testClistarFuncionario() {
		
		List<Funcionario> funcionarios = new FuncionarioDAO().listar();
		
		assertEquals(true, funcionarios.size()>0);
	}
	
	@Test
	public void testDexcluirCliente() {
				
		try {
			new FuncionarioService().excluir(f);
			
			f = FactoryDao.createFuncionarioDao().buscarPorId(f.getId());
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, f == null);
	}
	
	@Test
	public void testBalterarCliente() {
				
		
		f.setNome("Eduardo Cantu");
		f.setMatricula("e004");
		f.setCargo("Vendedor");
		f.setHorario("matinal");
		
		try {
			new FuncionarioService().alterar(f);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, f.getId() != null);
	}
	
}
