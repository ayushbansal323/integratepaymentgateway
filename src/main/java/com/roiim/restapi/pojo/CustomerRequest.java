package com.roiim.restapi.pojo;

import java.util.Random;

public class CustomerRequest {
	private String merchantCustomerId;

	private String locale;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date dateOfBirth;

	private String email;

	private String phone;

	private String ip;

	private String gender;

	private String nationality;

	private String cellPhone;
	
    public CustomerRequest() {
		super();
        this.locale = "en_US" ;
        this.firstName = "abc" ;
        this.middleName = "pqr" ;
        this.lastName = "xyz" ;
        Random lRandom = new Random(System.currentTimeMillis());
        this.merchantCustomerId = String.valueOf( lRandom.nextInt() ) ;
        Date lDob = new Date( 2, 3, 1998 );
        this.setDateOfBirth( lDob );
        
		this.cellPhone = "9056482124";
		this.gender = "M" ;
		this.nationality = "Canadian" ;
		this.phone = "777-444-8888" ;
		this.ip = "192.0.126.111" ;
		// TODO Auto-generated constructor stub
	}

	public String getMerchantCustomerId() {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(String merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "CreateNewCustomerRequestDTO{" +
                "merchantCustomerId='" + merchantCustomerId + '\'' +
                ", locale='" + locale + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ip='" + ip + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }


}
