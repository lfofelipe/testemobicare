package br.com.mobicare.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mobicare.model.dao.DAOException;
import br.com.mobicare.model.entity.Departamento;
import br.com.mobicare.model.entity.Empregado;
import br.com.mobicare.model.service.DepartamentoService;

@Controller(value = "depCtrl")
public class DepartamentoController {

	@Autowired
	private DepartamentoService DepartamentoService;
	@Autowired
	private EmpregadoController empCtrl;
	private int departamentoZero=0;
	private Departamento Departamento = new Departamento();
	private List<Departamento> DepartamentoList;

	public DepartamentoController() {

	}
	
	@PostConstruct
	public void init() {
		try {
			setDepartamentoList(DepartamentoService.buscarTodos());
			contaDep();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir(Departamento Departamento) throws DAOException {
		try {
			//Efeito cascata
			empCtrl.deletarpordep(Departamento.getId().intValue());
			//remove do banco
			DepartamentoService.excluir(Departamento);
			//remove da lista(view)
			DepartamentoList.remove(Departamento);
			//Atualiza contador de departamentos zerados
			contaDep();
			MensagemUtil.mensagemAviso(MensagemUtil.EXCLUIDO_SUCESSO);
		} catch (Exception e) {
			MensagemUtil.mensagemAviso(MensagemUtil.FALHA_EXCLUSAO);
			e.printStackTrace();
		}
	}
	/** Metodo que atualiza o contador de departamentos zerados
	 */
	public void contaDep(){
		int cont=0;
		List<Departamento> auxList=DepartamentoService.buscarTodos();
		for (int i = 0; i < auxList.size(); i++) {
			if (auxList.get(i).getEmpregados().isEmpty())
				cont++;
		}
		departamentoZero=cont;
	}
	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento Departamento) {
		this.Departamento = Departamento;
	}

	public List<Departamento> getDepartamentoList() {
		return DepartamentoList;
	}

	public void setDepartamentoList(List<Departamento> DepartamentoList) {
		this.DepartamentoList = DepartamentoList;
	}

	public int getDepartamentoZero() {
		return departamentoZero;
	}

	public void setDepartamentoZero(int departamentoZero) {
		this.departamentoZero = departamentoZero;
	}

}
