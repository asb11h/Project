package crud.business;

import java.io.Serializable;

//Reality-check: zip should be int, phone long, balance and totalSales BigDecimal data types
public class Customer implements Serializable {
	private String id;
    private String fname;
	private String lname;
	private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String balance;
    private String totalSales;
    private String notes;
	
	//default constructor
	public Customer()
	{
			id = "";
            fname = "";
			lname = "";
			street = "";
        	city = "";
        	state = "";
        	zip = "";
        	phone = "";
        	email = "";
        	balance = "";
        	totalSales = "";
        	notes = "";
    }

	//constructor with parameters
	public Customer
		(
		 String parId, String parFirstName, String parLastName, String parStreet, 
		 String parCity, String parState, String parZip, 
		 String parPhone, String parEmail, 
         String parBalance, String parTotalSales, String parNotes
		 )
	{
			this.id = parId;
            this.fname = parFirstName;
			this.lname = parLastName;
			this.street = parStreet;
        	this.city = parCity;
        	this.state = parState;
        	this.zip = parZip;
        	this.phone = parPhone;
        	this.email = parEmail;
        	this.balance = parBalance;
        	this.totalSales = parTotalSales;
        	this.notes = parNotes;
    }

/*
Note: The JavaBeans Specification says that for a property propertyName there should be a getter method getPropertyName() and/or a setter method setPropertyName(). 

//Java getter/setter method names must start with get/set, followed by the capitalized property name, example:

private String foo;

public String getFoo() {
  return foo;
}

http://stackoverflow.com/questions/8969112/confused-about-naming-of-javabean-properties-with-respect-to-getters-and-setter?lq=1

JavaBean specification:
http://download.oracle.com/otndocs/jcp/7224-javabeans-1.01-fr-spec-oth-JSpec/
*/

	//getter/setter methods:	

	//id
    public String getId() {
        return id;
    }

    public void setId(String parId) {
        this.id = parId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String parFirstName) {
        this.fname = parFirstName;
    }

	//lname
    public String getLname() {
        return lname;
    }

    public void setLname(String parLastName) {
        this.lname = parLastName;
    }

	//street
    public String getStreet() {
     return street;
    }

    public void setStreet(String parStreet) {
        this.street = parStreet;
    }

     public String getCity() {
     return city;
    }

    public void setCity(String parCity) {
        this.city = parCity;
    }

    public String getState() {
     return state;
    }

    public void setState(String parState) {
        this.state = parState;
    }

    public String getZip() {
     return zip;
    }

    public void setZip(String parZip) {
        this.zip = parZip;
    }

    public String getPhone() {
     return phone;
    }

    public void setPhone(String parPhone) {
        this.phone = parPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String parEmail) {
        this.email = parEmail;
    }

    public String getBalance() {
     return balance;
    }

    public void setBalance(String parBalance) {
        this.balance = parBalance;
    }

    public String getTotalSales() {
     return totalSales;
    }

    public void setTotalSales(String parTotalSales) {
        this.totalSales = parTotalSales;
    }

    public String getNotes() {
     return notes;
    }

    public void setNotes(String parNotes) {
        this.notes = parNotes;
    }
}
