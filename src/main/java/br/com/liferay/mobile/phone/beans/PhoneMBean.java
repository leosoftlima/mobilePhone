package br.com.liferay.mobile.phone.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.liferay.mobile.phone.controller.BusinessLogicFacade;
import br.com.liferay.mobile.phone.domain.Phone;
/**
 * Leonardo Lima
 * 27/08/2014
 */

@ManagedBean(name="phoneMbean")
@ViewScoped
@Component
public class PhoneMBean implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	@Autowired
	private BusinessLogicFacade facade;
	
	private Phone phone;
	private boolean flagIncluirAlterar;
	
	public PhoneMBean() {phone = new Phone();}			
	
	public String incluirPhone(){
		try {
		
		getFacade().inserirPhone(getPhone());		
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mobile Phone sucess. ", "sucess.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		} catch (SQLException e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no sistema. ", "erro.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "/pages/view.xhtml?faces-redirect=true";
	}
	
	public String alterarPhone(){
		
		try {
			getFacade().atualizar(getPhone());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no sistema. ", "erro.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mobile Phone sucess. ", "sucess.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
		return "/pages/view.xhtml?faces-redirect=true";
	}
	
	public String excluir(){
		try {
			getFacade().delete(getPhone().getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no sistema. ", "erro.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mobile Phone sucess. ", "sucess.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
		return "/pages/view.xhtml?faces-redirect=true";
	}
	
	public List<Phone> getPhones(){
		return 	getFacade().getMobilePhones();
	}

	public BusinessLogicFacade getFacade() {
		return facade;
	}

	public void setFachada(BusinessLogicFacade facade) {
		this.facade = facade;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public String carregarTelaAlteracao(Phone phone){
		flagIncluirAlterar = false;
		setPhone(phone);
		return "/pages/edit.xhtml?faces-redirect=true";
	}
	public String carregarTelaAdicionar(){
		setPhone(new Phone());
		flagIncluirAlterar = true;
		return "/pages/edit.xhtml?faces-redirect=true";
	}
	
	public String voltar(){
		return "/pages/view.xhtml?faces-redirect=true";
	}

	
	public boolean isFlagIncluirAlterar() {
		return flagIncluirAlterar;
	}
	
	
}
