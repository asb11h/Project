package crud.data;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

	/*
Notes:
The Java Naming and Directory Interface (JNDI) is a Java API for a directory service that allows Java software clients to discover and look up data and objects via a name.
https://en.wikipedia.org/wiki/Java_Naming_and_Directory_Interface

As of Tomcat 4, Tomcat provides a JNDI InitialContext implementation instance to web applications running under it, in a manner that is compatible with those provided by a Java2 Enterprise Edition application server. Entries in this InitialContext are configured in the $CATALINA_HOME/conf/server.xml file.

The InitialContext is configured as a web application is initially deployed, and is made available to web application components (for read-only access). All configured entries and resources will be placed in the java:comp/env portion of the JNDI namespace.
https://tomcat.apache.org/tomcat-4.0-doc/jndi-resources-howto.html

Hence, begin with java:/comp/env
then add the remaining context value from the name attribute of the context.xml file in META-INF:
name="jdbc/yourfsuid"

Therefore, the full IntialContext lookup() value would be:
ic.lookup("java:/comp/env/jdbc/yourfsuid")
	*/
	
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/asb11h");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
