package br.com.liferay.mobile.phone.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.liferay.mobile.phone.domain.Phone;

/**
 * Leonardo Lima , 27/08/2014
 * 
 */

@Service
@Transactional
public class BusinessLogicFacade implements Facade{

	@Autowired
	private PhoneController phoneController;	 

	/*
	 * (non-Javadoc)
	 * @see br.com.liferay.mobile.phone.controller.Facade#inserirPhone(br.com.liferay.mobile.phone.domain.Phone)
	 */
	public void inserirPhone(Phone phone) throws SQLException{
		phoneController.inserirPhone(phone);
	}
	/*
	 * (non-Javadoc)
	 * @see br.com.liferay.mobile.phone.controller.Facade#getMobilePhones()
	 */
	public List<Phone> getMobilePhones(){
		return phoneController.listarTodosMobilePhone();
	}
	/*
	 * (non-Javadoc)
	 * @see br.com.liferay.mobile.phone.controller.Facade#delete(java.lang.Integer)
	 */
	public void delete(Integer id) throws SQLException {
		phoneController.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.liferay.mobile.phone.controller.Facade#atualizar(br.com.liferay.mobile.phone.domain.Phone)
	 */
	public void atualizar(Phone phone) throws SQLException {
		phoneController.atualizar(phone);
	}
}
