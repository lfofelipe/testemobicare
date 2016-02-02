package br.com.mobicare.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobicare.model.dao.DAOException;
import br.com.mobicare.model.dao.DepartamentoDAO;
import br.com.mobicare.model.entity.Departamento;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoDAO depDAO;

	public Departamento salvar(Departamento dep) throws ServiceException {
		try {
			return depDAO.salvar(dep);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public void excluir(Departamento dep) throws ServiceException {
		try {
			depDAO.excluir(dep);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Departamento> buscarTodos() {
		return depDAO.buscarTodos();
	}

	public Departamento buscaPorId(int id) {
		return depDAO.buscarPorId(id);
	}
}
