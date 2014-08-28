package br.com.liferay.mobile.phone.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.liferay.mobile.phone.domain.Phone;

public interface Facade {

	/**
	 * Método para inserir Phone
	 * @param phone
	 * @throws SQLException
	 */
	public void inserirPhone(Phone phone) throws SQLException;
	/**
	 * Lista todos os phone disponível no banco de dados
	 * @return List<Phone>
	 */
	public List<Phone> getMobilePhones();
	/**
	 * Remove do banco de dados o phone 
	 * @param id
	 * @throws SQLException
	 */
	public void delete(Integer id) throws SQLException ;
	/**
	 * Atualiza os dados do phone na base de dados
	 * @param phone
	 * @throws SQLException
	 */
	public void atualizar(Phone phone) throws SQLException;
}
