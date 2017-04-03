package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bligic.Person;

public class PersonDAO_MsSQL implements PersonDAO
{
	   String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;" +  
		         "databaseName=person;user=work;password=work";
	   String dburl= "jdbc:sqlserver://localhost\\SQL2014:1433;" +
			     "databaseName=person;user=work;password=work";
	   String url = "jdbc:sqlserver://work_pc\\SQLEXPRESS:1433;user=work;password=work;databaseName=person";
	   
	@Override
	public void create(Person p) 
	{
		Connection con = null;
		try
		{
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection (dburl);
			Statement st = con.createStatement();
			String str = "INSERT INTO `person`.`person` " + "VALUES (" + p.id + ", '" + p.fname + "', '" +
					p.lname + "', " +  p.age + ")";
			st.executeUpdate(str);
			con.close();
		}
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		Connection con = null;
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection (dburl);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person");
			while( rs.next() )
			{
				pp.add( new Person(rs.getInt(1), rs.getString("fname"), rs.getString(3), rs.getInt("age")) ); 
			}
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		Connection con = null;
		try 
		{
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection (dburl);
			Statement st = con.createStatement();
			String str = "UPDATE person SET " + "fname = '" + p.fname+"', "+"lname = '" + p.lname +"', "+" age = '" + p.age +"' WHERE id =" +p.id;

			st.executeUpdate(str);
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}


	}

	@Override
	public void delete(Person p) 
	{
		Connection con = null;
		try 
		{
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection (dburl);
			Statement st = con.createStatement();
			String str = "DELETE FROM PERSON WHERE ID=" + p.id ;
			st.executeUpdate(str);
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

