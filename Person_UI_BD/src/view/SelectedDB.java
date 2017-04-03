package view;

import dal.PersonDAO;
import dal.PersonDAO_CSV_Auto;
import dal.PersonDAO_H2;
import dal.PersonDAO_JSON_Auto;
import dal.PersonDAO_Mock;
import dal.PersonDAO_Mongo;
import dal.PersonDAO_MsSQL;
import dal.PersonDAO_MySQL;
import dal.PersonDAO_NetClient;
import dal.PersonDAO_XML_Auto;
import dal.PersonDAO_YAML_Auto;

public class SelectedDB 
{
	public PersonDAO_H2 h2= null;
	public PersonDAO_Mock mock= null;
	public PersonDAO_MySQL mySQL= null;
	public PersonDAO_MsSQL msq= null;
	public PersonDAO_Mongo mongo= null;

	public PersonDAO_CSV_Auto csvObj =null;
	public PersonDAO_YAML_Auto yamlObj =null;
	public PersonDAO_XML_Auto xmlObj =null;
	public PersonDAO_JSON_Auto jsonObj =null;
	public PersonDAO_NetClient  netClient = null;
	public SelectedDB()
	{
		
	}
	public PersonDAO getDB(String type)
	{
		PersonDAO person = null;
		if (type.equals("Mock") )
		{
			if (mock==null)
			{
				mock = new PersonDAO_Mock();
				person=mock;
			}
			else
			{
				person=mock;
			}
			
		}
		if (type.equals("H2") )
		{
			if (h2==null)
			{
				h2 = new PersonDAO_H2();
				person=h2;
			}
			else
			{
				person=h2;
			}
		}
		if (type.equals("MySQL") )
		{
			if (mySQL==null)
			{
				mySQL = new PersonDAO_MySQL();
				person=mySQL;
			}
			else
			{
				person=mySQL;
			}
		}
		if (type.equals("CSV") )
		{
			if (csvObj==null)
			{
				csvObj = new PersonDAO_CSV_Auto();
				person=csvObj;
			}
			else
			{
				person=csvObj;
			}
		}
		if (type.equals("YAML") )
		{
			if (yamlObj==null)
			{
				yamlObj = new PersonDAO_YAML_Auto();
				person=yamlObj;
			}
			else
			{
				person=yamlObj;
			}
		}
		if (type.equals("XML") )
		{
			if (xmlObj==null)
			{
				xmlObj = new PersonDAO_XML_Auto();
				person=xmlObj;
			}
			else
			{
				person=xmlObj;
			}
		}
		if (type.equals("JSON") )
		{
			if (jsonObj==null)
			{
				jsonObj = new PersonDAO_JSON_Auto();
				person=jsonObj;
			}
			else
			{
				person=jsonObj;
			}
		}
		if (type.equals("MsSQL") )
		{
			if (msq==null)
			{
				msq = new PersonDAO_MsSQL();
				person=msq;
			}
			else
			{
				person=msq;
			}
		}
		if (type.equals("MongoDB") )
		{
			if (mongo==null)
			{
				mongo = new PersonDAO_Mongo();
				person=mongo;
			}
			else
			{
				person=mongo;
			}
		}
		if (type.equals("NetClient") )
		{
			if (netClient==null)
			{
				netClient = new PersonDAO_NetClient();
				person=netClient;
			}
			else
			{
				person=netClient;
			}
		}
		return person;
	}
}
