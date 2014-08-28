package br.com.liferay.mobile.phone.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.liferay.mobile.phone.dao.PhoneDAO;
import br.com.liferay.mobile.phone.domain.Phone;

/**
 * Leonardo Lima
 * 27/08/2014
 */
@Service
public class PhoneController {
	
	@Autowired
	PhoneDAO phoneDAO;
	/**
	 * 
	 */
	public List<Phone> listarTodosMobilePhone(){
		return phoneDAO.listarTodosMobilePhone();
	}
	public void inserirPhone(Phone phone) throws SQLException{
		phoneDAO.inserirPhone(phone);
	}
	
	public void delete(Integer id) throws SQLException {
		phoneDAO.delete(id);
	}
	public void atualizar(Phone phone) throws SQLException {
		phoneDAO.atualizar(phone);
	}

}
