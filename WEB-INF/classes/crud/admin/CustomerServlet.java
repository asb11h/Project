package crud.admin;

import java.io.*;

//Note: ArrayList provides *dynamic* resizable-array (i.e., items can be added and removed from list), unlike simple Array
import java.util.*; //example: ArrayList<SomeCollection>
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import crud.business.Customer;
import crud.data.CustomerDB;

@WebServlet("/customerAdmin")
public class CustomerServlet extends HttpServlet {

	//for all post submissions
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

			//if no current session, returns new session
        HttpSession session = request.getSession();

				//initialize url variable - used below to direct user to appropriate page	
        String url = "/index.jsp";
        
        //initialize current action and customer id
        String action = null;
        String cid = null;

				//set actions and customer ids accordingly
				if (request.getParameter("display_customer") != null) {
					action = "display_customer";
					cid = request.getParameter(action);
 				} else if (request.getParameter("add_customer") != null) {
					action = "add_customer";
					cid=null;
				} else if (request.getParameter("update_customer") != null) {
            action = "update_customer";
				 cid = request.getParameter(action);						
				} else if (request.getParameter("delete_customer") != null) {
            action = "delete_customer";
				 cid = request.getParameter(action);						
				}
			
        // perform action and set URL to appropriate page
				if (action.equals("display_customer")) {
					//String cid = request.getParameter("id");
					Customer customer = CustomerDB.selectCustomer(cid);
					session.setAttribute("customer", customer);
					url = "/customer.jsp";
            } else if (action.equals("add_customer")) {
            // get parameters from the request (data conversions not required here)
					//Reality-check: zip should be int, phone long, balance and totalSales BigDecimal data types
					//getParameter() method accepts values from form control *name* attribute
            		String id = request.getParameter(null);
					String firstName = request.getParameter("fname");
					String lastName = request.getParameter("lname");
					String street = request.getParameter("street");
            		String city = request.getParameter("city");
            		String state = request.getParameter("state");
            		String zip = request.getParameter("zip");
            		String phone = request.getParameter("phone");
            		String email = request.getParameter("email");
            		String balance = request.getParameter("balance");
            		String totalSales = request.getParameter("total_sales");
            		String notes = request.getParameter("notes");

					//instantiate new customer object with associated object variable (customer)
					Customer customer = new Customer(id, firstName, lastName, street, city, state, zip, phone, email, balance, totalSales, notes);

					//declare message variable
					String message; 
					//here: check *only* for data entry
					//empty string: string with zero length.
					//null value: is unknown value--not having a string.

					//Reality-check: in production environment need rigorous data validation:
						//http://java-source.net/open-source/validation
            if (
								firstName == null || lastName == null || street == null ||
								city == null || state == null || zip == null || phone == null ||
								email == null || balance == null || totalSales == null ||
								
								firstName.isEmpty() || lastName.isEmpty() || street.isEmpty() ||
								city.isEmpty() || state.isEmpty() || zip.isEmpty() || phone.isEmpty() ||
								email.isEmpty() || balance.isEmpty() || totalSales.isEmpty()
						)
							{
                message = "All text boxes required except Notes.";
                url = "/index.jsp";
							}
            else
							{
                message = "";
                url = "/thanks.jsp";
                CustomerDB.insert(customer);
							}
            request.setAttribute("customer", customer);
            request.setAttribute("message", message);
        } else if (action.equals("update_customer")) {
            // get parameters from the request
				 String firstName = request.getParameter("fname");
				 String lastName = request.getParameter("lname");
				 String street = request.getParameter("street");
            	 String city = request.getParameter("city");
            	 String state = request.getParameter("state");
            	 String zip = request.getParameter("zip");
            	 String phone = request.getParameter("phone");
            	 String email = request.getParameter("email");
            	 String balance = request.getParameter("balance");
            	 String totalSales = request.getParameter("total_sales");
            	 String notes = request.getParameter("notes");

            // get and update customer
            Customer customer = (Customer) session.getAttribute("customer");        
            customer.setId(cid);
            customer.setFname(firstName);
            customer.setLname(lastName);
            customer.setStreet(street);
            customer.setCity(city);
            customer.setState(state);
            customer.setZip(zip);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setBalance(balance);
            customer.setTotalSales(totalSales);
            customer.setNotes(notes);

				 url = "/modify.jsp";
            // update customer				 
            CustomerDB.update(customer);

            // get and set updated customers
            ArrayList<Customer> customers = CustomerDB.selectCustomers();            
            request.setAttribute("customers", customers);            
        } else if (action.equals("delete_customer")) {
            // get customer
            Customer customer = CustomerDB.selectCustomer(cid);

				 url = "/modify.jsp";
            // delete customer
            CustomerDB.delete(customer);
            
            // get and set updated customers
            ArrayList<Customer> customers = CustomerDB.selectCustomers();            
            request.setAttribute("customers", customers);            
        }
	
				//forward (not redirect), can provide additional security, as user does not see actual URL
				getServletContext()
                .getRequestDispatcher(url)
					.forward(request, response);
				
				//sometimes, better to redirect than forward (e.g., insert/update/delete or to see correct URL)
				//response.sendRedirect(url);
				//response.sendRedirect("index.jsp"); //or literal value
    }    

	//for all get submissions	
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

				String url = "/modify.jsp";

					// get list of customers				
					ArrayList<Customer> customers = CustomerDB.selectCustomers();            
					request.setAttribute("customers", customers);
				
				//forward (not redirect)
				getServletContext()
                .getRequestDispatcher(url)
					.forward(request, response); 

				//sometimes, better to redirect than forward (e.g., insert/update/delete or to see correct URL)				
				//response.sendRedirect(url);
				//response.sendRedirect("index.jsp");								
    }
}
