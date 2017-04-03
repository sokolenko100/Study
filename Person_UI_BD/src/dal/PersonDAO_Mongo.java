package dal;

import java.util.ArrayList;
import java.util.Properties;

import bligic.Person;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class PersonDAO_Mongo implements PersonDAO
{
	private Properties prop;
	private MongoClient mongoClient;
	private DB db;
	private DBCollection table;


	@Override
	protected void finalize() throws Throwable
	{
		mongoClient.close();
		super.finalize();
	}

	public PersonDAO_Mongo() 
	{
		prop = new Properties();
		prop.setProperty("host", "localhost");
		prop.setProperty("port", "27017");
		prop.setProperty("dbname", "Persons");
		prop.setProperty("login", "user1");
		prop.setProperty("password", "root");
		prop.setProperty("table", "PersonTable");

		try
		{
			mongoClient = new MongoClient(prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
		} 
		catch (NumberFormatException e){ e.printStackTrace(); } 
		db = mongoClient.getDB(prop.getProperty("dbname"));
		//     authenticate = db.authenticate(prop.getProperty("login"), prop.getProperty("password").toCharArray());
		table = db.getCollection(prop.getProperty("table"));

	}

	@Override
	public void create(Person p) 
	{
		BasicDBObject person = new BasicDBObject();
		person.put("id", p.id);
		person.put("firstName", p.fname);
		person.put("lastName", p.lname);
		person.put("age", p.age);
		table.insert(person);
	}

	@Override
	public ArrayList<Person> read() 
	{
		// public User getByLogin(String login){
		//     BasicDBObject query = new BasicDBObject();
		//      
		//     // задаем поле и значение поля по которому будем искать
		//     query.put("login", login);
		//  
		//     // осуществляем поиск
		//     DBObject result = table.findOne(query);
		//     
		//     // Заполняем сущность полученными данными с коллекции
		//     User user = new User();
		//     user.setLogin(String.valueOf(result.get("login")));
		//     user.setId(String.valueOf(result.get("_id")));
		//   
		//     // возвращаем полученного пользователя
		//     return user;
		ArrayList<Person> pp = new ArrayList<>();
		try
		{ 
			DBCursor cursor = table.find();
			while (cursor.hasNext()) 
			{
				DBObject str = cursor.next();
				pp.add(new Person((int)Double.parseDouble(str.get("id").toString()), str.get("firstName").toString(), str.get("lastName").toString(), (int)Double.parseDouble(str.get("age").toString())));
			}  
		}
		catch (Exception e) {}
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		BasicDBObject newData = new BasicDBObject();
		newData.put("id", p.id);
		newData.put("firstName", p.fname);
		newData.put("lastName", p.lname);
		newData.put("age", p.age);

		BasicDBObject serchQery = new BasicDBObject().append("id", p.id);
		table.update(serchQery, newData);
	}

	@Override
	public void delete(Person p) 
	{
		BasicDBObject deletedObject = new BasicDBObject();
		deletedObject.put("id", p.id);
		table.remove(deletedObject);
	}

}