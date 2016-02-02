package br.com.mobicare.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mobicare.model.dao.DAOException;
import br.com.mobicare.model.entity.Departamento;
import br.com.mobicare.model.entity.Empregado;
import br.com.mobicare.model.service.DepartamentoService;
import br.com.mobicare.model.service.EmpregadoService;
import br.com.mobicare.model.service.ServiceException;

@Controller(value = "empCtrl")
public class EmpregadoController {

	@Autowired
	private EmpregadoService empregadoService;

	@Autowired
	private DepartamentoController depCtrl;
	
	@Autowired
	private DepartamentoService depS;

	private Empregado empregado = new Empregado();
	private List<Empregado> empregadoList;

	public EmpregadoController() {

	}
	@PostConstruct
	public void init() {
		try {
			setEmpregadoList(empregadoService.buscarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**Metodo que deleta todos os usuários que estão vinculados ao departamento a ser deletado
	 * @param id int
	 * @throws ServiceException
	 */
	public void deletarpordep(int id) {
		for (int i = 0; i < empregadoList.size(); i++) {
			Empregado emp = empregadoList.get(i);
			Departamento dep = emp.getDepartamento();
			if (dep.getId().intValue() == id) {
				try {
					empregadoService.excluir(emp);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				empregadoList.remove(emp);
				i--;
			}
		}
	}

	public void editar(Empregado empregado) {
		this.empregado = empregado;
	}

	public void excluir(Empregado Empregado) throws DAOException {
		try {
			// Exclui do banco
			Empregado empManaged = empregadoService.buscaPorId(Empregado.getId());
			empregadoService.excluir(empManaged);
			// Remove da Lista
			empregadoList.remove(Empregado);
			depCtrl.contaDep();
			MensagemUtil.mensagemAviso(MensagemUtil.EXCLUIDO_SUCESSO);
		} catch (Exception e) {
			MensagemUtil.mensagemAviso(MensagemUtil.FALHA_EXCLUSAO);
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			Empregado empSalvo = empregadoService.salvar(empregado);
			if (empregado.getId() == null)
				empregadoList.add(empSalvo);

			// Limpando
			empregado = new Empregado();
			MensagemUtil.mensagemAviso(MensagemUtil.SALVO_SUCESSO);
		} catch (ServiceException e) {
			// Limpando
			empregado = new Empregado();
			MensagemUtil.mensagemAviso(MensagemUtil.FALHA_SALVAR);
			e.printStackTrace();
		}
		depCtrl.contaDep();
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}

	public List<Empregado> getEmpregadoList() {
		return empregadoList;
	}

	public void setEmpregadoList(List<Empregado> EmpregadoList) {
		this.empregadoList = EmpregadoList;
	}

}
