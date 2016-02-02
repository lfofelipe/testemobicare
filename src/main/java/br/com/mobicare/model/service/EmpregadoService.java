package br.com.mobicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobicare.model.dao.DAOException;
import br.com.mobicare.model.dao.EmpregadoDAO;
import br.com.mobicare.model.entity.Empregado;

@Service
public class EmpregadoService {

	@Autowired
	EmpregadoDAO empDAO;

	public Empregado salvar(Empregado emp) throws ServiceException {
		try {
			return empDAO.salvar(emp);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public void excluir(Empregado emp) throws ServiceException {
		try {
			empDAO.excluir(emp);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Empregado> buscarTodos() {
		return empDAO.buscarTodos();
	}

	public Empregado buscaPorId(int id) {
		return empDAO.buscarPorId(id);
	}
}
