package com.roiim.dao;

import com.roiim.pojo.Customer;

public interface CustomerDAO {

		public String getCustomerIDFromEmail(String pstrEmail);

		public int insertCustomer(Customer pCustomer);
		
}
