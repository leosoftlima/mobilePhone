package br.com.liferay.mobile.phone.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.com.liferay.mobile.phone.domain.Phone;
/**
 * Leonardo Lima , * 27/08/2014
 */
@Service
public class PhoneDAO{
	
	@Autowired
	private DataSource dataSource;

	public List<Phone> listarTodosMobilePhone(){
		String query = "SELECT * FROM PHONE";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Phone> listPhones = new ArrayList<Phone>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		for (Map row : rows) {
			Phone phone = new Phone();

			phone.setId((Integer)row.get("ID"));
			phone.setName((String)row.get("NAME"));
			phone.setBrand((String)row.get("BRAND"));
			phone.setDescription((String)row.get("DESCRIPTION"));
			phone.setReleaseDate((Date)row.get("RELEASE_DATE"));
			phone.setPrice((Double)row.get("PRICE"));

			listPhones.add(phone);
		}

		return listPhones;

	}

	public void inserirPhone(Phone phone) throws SQLException{
		/*
		 * o campo zero no values indica que o autoincrement do Mysql esta configurado.
		 */
		String query = "INSERT INTO PHONE (ID,NAME,BRAND,DESCRIPTION,RELEASE_DATE,PRICE) VALUES(0,?,?,?,?,?)";

		Object[] parametros = {phone.getName(),phone.getBrand(),
				phone.getDescription(),phone.getReleaseDate(),
				phone.getPrice()
		};

		executeUpdateSQL(query, parametros);	

	}

	public void delete(Integer id) throws SQLException {
		String sql = "DELETE FROM PHONE WHERE ID = ?";
		Object[] parametros = {id};

		executeUpdateSQL(sql, parametros);		
	}

	public void atualizar(Phone phone) throws SQLException {
		String sql = "update phone set name = ?,brand = ?, description = ?,release_date = ?, price = ? where id=?";
		Object[] parametros = { phone.getName(), phone.getBrand(),
				phone.getDescription(),new java.sql.Date(phone.getReleaseDate().getTime()),
				phone.getPrice(),phone.getId()};

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, parametros);	
	}

	private void executeUpdateSQL(String sql, Object[] parametros) throws SQLException{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, parametros);
	}


}
