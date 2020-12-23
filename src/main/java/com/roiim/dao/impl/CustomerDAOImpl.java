package com.roiim.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.roiim.dao.CustomerDAO;
import com.roiim.pojo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	JdbcTemplate jt;

	public String getCustomerIDFromEmail(String pstrEmail) {
		String pstrCustomerID = null;
		try {
			pstrCustomerID = jt.queryForObject("select customer_id from customer where email='" + pstrEmail+"'", new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("customer_id");
				}
			});
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			pstrCustomerID = null;
		}
		return pstrCustomerID;
	}
	
	public int insertCustomer(Customer pCustomer) {
		final Customer lCustomer = pCustomer;
		int count = jt.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con
						.prepareStatement("insert into customer(customer_id,email) " + "values(?,?)");
				pst.setString(1, lCustomer.getCustomerId());
				pst.setString(2, lCustomer.getEmail());
				
				return pst;
			}
		});
		if (count == 1)
			return 1;
		return -1;
	}

}
