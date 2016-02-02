package br.com.mobicare.model.service;

import br.com.mobicare.model.dao.DAOException;

public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(DAOException e) {
		super(e);
	}

}
