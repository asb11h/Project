package crud.data;

import java.sql.*;
import java.util.ArrayList;

import crud.business.Customer;

public class CustomerDB {

    public static int insert(Customer customer) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
				//unfortunately, JDBC doesn't make it easy to use named parameters (:name) instead of indices. :(
        String query
					= "INSERT INTO customer (cus_fname, cus_lname, cus_email) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFname());
            ps.setString(2, customer.getLname());
            ps.setString(3, customer.getEmail());
						
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Customer customer) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
				
        String query = "UPDATE customer SET "
                + "cus_fname = ?, "
                + "cus_lname = ?, "
                + "cus_email = ?, ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFname());
            ps.setString(2, customer.getLname());
            ps.setString(3, customer.getEmail());
						
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Customer customer) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM customer ";
        try {
            ps = connection.prepareStatement(query);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Customer selectCustomer(String id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM customer ";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            Customer customer = null;
            if (rs.next()) {
                customer = new Customer();
					 customer.setId(id);								
					 customer.setFname(rs.getString("cus_fname"));
					 customer.setLname(rs.getString("cus_lname"));
					 customer.setEmail(rs.getString("cus_email"));
            }
            return customer;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Customer> selectCustomers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM customer";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Customer> customers = new ArrayList<Customer>();
            while (rs.next())
            {
                Customer customer = new Customer();
                customer.setId(rs.getString("cus_id"));								
                customer.setFname(rs.getString("cus_fname"));
                customer.setLname(rs.getString("cus_lname"));
                customer.setEmail(rs.getString("cus_email"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
}
