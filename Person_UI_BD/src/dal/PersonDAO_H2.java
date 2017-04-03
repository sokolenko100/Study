package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bligic.Person;

public class PersonDAO_H2 implements PersonDAO
{
	@Override
	public void create(Person p) 
	{
		try
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement st = con.createStatement();
			String str = "INSERT INTO PERSON VALUES(" + p.id + ", '" + p.fname + "', '" +
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
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Person");
			while( rs.next() )
			{
				pp.add( new Person(rs.getInt(1), rs.getString("FNAME"), rs.getString(3), rs.getInt("AGE")) ); 
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
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement st = con.createStatement();
			String str = "UPDATE PERSON SET FNAME= '" + p.fname +  "', LNAME= '" + p.lname + "', AGE = " + p.age + "WHERE ID =" + p.id;
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
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
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
