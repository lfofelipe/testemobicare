package br.com.mobicare.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static final String EXCLUIDO_SUCESSO = "Objeto excluído com sucesso.";
	public static final String FALHA_EXCLUSAO = "Ocorreu um erro ao excluír o objeto.";
	public static final String SALVO_SUCESSO = "Objeto salvo com sucesso!";
	public static final String FALHA_SALVAR = "Ocorreu um erro ao salvar o objeto.";
	public static void mensagemInfo(String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void mensagemErro(String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public static void mensagemAviso(String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
