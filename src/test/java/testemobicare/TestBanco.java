package testemobicare;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.mobicare.model.dao.DAOException;
import br.com.mobicare.model.dao.DepartamentoDAO;
import br.com.mobicare.model.dao.EmpregadoDAO;
import br.com.mobicare.model.entity.Departamento;
import br.com.mobicare.model.entity.Empregado;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestBanco {
	@Autowired
	DepartamentoDAO depDAO;

	@Autowired
	EmpregadoDAO empDAO;

	//Adicionando Departamento
	@SuppressWarnings("deprecation")
	@Test
	public void salvar() throws DAOException {
		Empregado emp = new Empregado();
		emp.setFuncao("Analista");
		emp.setNome("Maria");
		List<Empregado> empregados = new ArrayList();
		empregados.add(emp);
		
		Departamento dep = new Departamento();
		dep.setDescricao("RH");

		dep.setEmpregados(empregados);
		
		emp.setDepartamento(dep);
		
		
		depDAO.salvar(dep);
		Empregado e = empDAO.salvar(emp);
		Assert.assertNotNull(dep.getId());
	}
}
