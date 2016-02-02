package br.com.mobicare.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mobicare.model.entity.Departamento;
import br.com.mobicare.model.service.DepartamentoService;

@Component
public class DepartamentoConverter implements Converter{

	@Autowired
	DepartamentoService depService;
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idTela) {
		if (idTela != null && !idTela.equals("")) {
			Departamento d = depService.buscaPorId(Integer.parseInt(idTela));
		return d;
		}
		else
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objDepartamento) {
		try{
		Departamento d = (Departamento) objDepartamento;
		return d.getId().toString();
		}catch(Exception e){
			return null;
		}
	}

}
