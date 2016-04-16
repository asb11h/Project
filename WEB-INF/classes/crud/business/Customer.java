package crud.business;

import java.io.Serializable;

//Reality-check: zip should be int, phone long, balance and totalSales BigDecimal data types
public class Customer implements Serializable {
	private String fname;
	private String lname;
	private String email;
	
	//default constructor
	public Customer()
	{
			fname = "";
			lname = "";
			email = "";
    }

	//constructor with parameters
	public Customer
		(
		 String parFirstName, String parLastName, String parEmail
		 )
	{
			this.fname = parFirstName;
			this.lname = parLastName;
			this.email = parEmail;
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

	//fname
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

	//email
    public String getEmail() {
        return email;
    }

    public void setEmail(String parEmail) {
        this.email = parEmail;
    }
}
