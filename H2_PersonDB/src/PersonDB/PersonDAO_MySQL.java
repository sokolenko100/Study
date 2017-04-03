package PersonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_MySQL implements PersonDAO
{
	@Override
	public void create(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false", "root" ,"1225");
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO `mydbtest`.`person` " + "VALUES ('" + p.id + "','" + p.fname + "','" + p.lname + "','" + p.age);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false", "root" ,"1225");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
			while (rs.next() )
			{
				pp.add( new Person( rs.getInt("id"), rs.getString(2), rs.getString("lname"), rs.getInt(4)) );
			}
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
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false", "root" ,"1225");
			Statement st = con.createStatement();
			st.executeUpdate("UPDATE Person SET Age = " + p.age + " WHERE id =" +p.id);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false", "root" ,"1225");
			Statement st = con.createStatement();
			st.executeUpdate("delete from person where id=" + p.id);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}

