package br.com.liferay.mobile.phone.beans;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class GenericsMBean {
	
	public String carregarTelaAdicionar(){
		return "/edit.xhtml?faces-redirect=true";
	}
	
	public String voltar(){
		return "/view.xhtml?faces-redirect=true";
	}
	
}
