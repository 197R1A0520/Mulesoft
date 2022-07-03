package com.santhosh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:/D:\\SQLite\\sqlite-tools-win32-x86-3390000\\Movies.db";
		
		try {
            Connection connection = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT rowid, * FROM Movies";
            
            
//            String sql = "SELECT Actor FROM Movies";
//            String sql = "SELECT Name FROM Movies";
//            String sql = "SELECT Director FROM Movies";
//            String sql = "SELECT Year_of_Release FROM Movies";
            
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next())
            {
            	Integer id = result.getInt("rowid");
            	String Name = result.getString("Name");
            	String Actor = result.getString("Actor");
            	String Actress = result.getString("Actress");
            	String Director = result.getString("Director");
            	String Year_of_Release = result.getString("Year_of_Release");
            	
            	System.out.println(id+" "+Name +" "+Actor+" "+Actress+" "+Director+" "+Year_of_Release);
            	            	
//            	System.out.println(id);
//            	System.out.println(Name);
//            	System.out.println(Actor);
//            	System.out.println(Actress);
//            	System.out.println(Director);
//            	System.out.println(Year_of_Release);
            	
            }
            
		}catch(SQLException e) {
			System.out.println("Error conneting to SQLite database");
			e.printStackTrace();
		}
		
	}

}
