package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class databaseConnector {
	private Connection connection;
	public databaseConnector() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

	       connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
	      try
	      {
	        
	         
	    	  System.out.println("DID Start DB");
	         Statement statement = connection.createStatement();
	         statement.setQueryTimeout(30);  
	          statement.executeUpdate("INSERT INTO `log`(`id`,`value`,`time`) VALUES (NULL,'Did start','"+ Instant.now() +"');\n" + "");   
	          
	          }

	     catch(SQLException e){  System.err.println(e.getMessage()); }       
	      finally {         
	            try {
	                  if(connection != null)
	                     connection.close();
	                  }
	            catch(SQLException e) {  //          
	               System.err.println(e); 
	             }
	      }
	  }
	
	public void log(String s) throws SQLException {
  	  System.out.println("DID Req log DB");
	       connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
		 Statement statement = connection.createStatement();
         statement.setQueryTimeout(30);  
         statement.executeUpdate("INSERT INTO `log`(`id`,`value`,`time`) VALUES (NULL,'"+s+"','"+ Instant.now() +"');\n" + "");   
         connection.close();

	}
	
	}


