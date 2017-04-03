package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import model.Person;

import org.junit.Test;

import HashTable.HashTableLine;



public class TestHT 
{
	HashTableLine hTable = new HashTableLine();
	
	
	Person[] ini_many = {
			new Person(10, "Vasia", 	"Pupkin", 		23),
			new Person(14, "Kasia", 	"Lupkin", 		27),
			new Person(17, "Masia",		"Gupkin",		19),
			new Person(33, "Gasia", 	"Hupkin", 		56),
			new Person(60, "Lasia", 	"Jupkin", 		99),
			new Person(71, "Andrey",	"Petrishe",  	12),
			new Person(12, "Volodya",	"Kovalevskij", 	23),
			new Person(34, "Sergey",	"Shevchenko", 	25),
			new Person(22, "Aleksey",	"Abrosimov", 	62),
			new Person(18, "Evgenii",	"Lopateckii", 	75),
			new Person(62, "Anton",		"Kobilko", 		82),
			new Person(51, "boris",		"Tkachuk", 		17),};
	Person[] ini_two = {  new Person(10, "Vasia", 	"Pupkin", 23),
						  new Person(14, "Kasia", 	"Lupkin", 27)};
	Person[] ini_one = {  new Person(10, "Vasia", 	"Pupkin", 23)};
	Person[] ini_null = {};



	@Test
	public void test_init_many() 
	{
		hTable.init(ini_many);
		Person[] act = hTable.toArray();
		Person[] exp = {
				new Person(10, "Vasia", 	"Pupkin", 		23),
				new Person(14, "Kasia", 	"Lupkin", 		27),
				new Person(17, "Masia",		"Gupkin",		19),
				new Person(33, "Gasia", 	"Hupkin", 		56),
				new Person(60, "Lasia", 	"Jupkin", 		99),
				new Person(71, "Andrey",	"Petrishe",  	12),
				new Person(12, "Volodya",	"Kovalevskij", 	23),
				new Person(34, "Sergey",	"Shevchenko", 	25),
				new Person(22, "Aleksey",	"Abrosimov", 	62),
				new Person(18, "Evgenii",	"Lopateckii", 	75),
				new Person(62, "Anton",		"Kobilko", 		82),
				new Person(51, "boris",		"Tkachuk", 		17),};
		assertEquals(exp.length, act.length);
	}
	@Test
	public void test_init_two() 
	{
		hTable.init(ini_two);
		Person[] act = hTable.toArray();
		Person[] exp = {  new Person(10, "Vasia", 	"Pupkin", 		23),
				  new Person(14, "Kasia", 	"Lupkin", 		27),};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_init_one() 
	{
		hTable.init(ini_one);
		Person[] act = hTable.toArray();
		Person[] exp = ini_one;
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_init_null() 
	{
		hTable.init(ini_null);
		Person[] act = hTable.toArray();
		Person[] exp = ini_null;
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_del_many() 
	{
		hTable.init(ini_many);
		hTable.del(ini_many[0]);
		Person[] act = hTable.toArray();
		
		Person[] exp = {
				new Person(14, "Kasia", 	"Lupkin", 		27),
				new Person(17, "Masia",		"Gupkin",		19),
				new Person(33, "Gasia", 	"Hupkin", 		56),
				new Person(60, "Lasia", 	"Jupkin", 		99),
				new Person(71, "Andrey",	"Petrishe",  	12),
				new Person(12, "Volodya",	"Kovalevskij", 	23),
				new Person(34, "Sergey",	"Shevchenko", 	25),
				new Person(22, "Aleksey",	"Abrosimov", 	62),
				new Person(18, "Evgenii",	"Lopateckii", 	75),
				new Person(62, "Anton",		"Kobilko", 		82),
				new Person(51, "boris",		"Tkachuk", 		17),};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_ini_two() 
	{
		hTable.init(ini_two);
		hTable.del(ini_two[0]);
		Person[] act = hTable.toArray();
		Person[] exp = {ini_two[1]};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_del_one() 
	{
		hTable.init(ini_one);
		hTable.del(ini_one[0]);
		Person[] act = hTable.toArray();
		Person[] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test(expected=IllegalArgumentException.class)
	public void test_del_null() 
	{
		hTable.init(ini_null);
		hTable.del(new Person(10, "Vasia","Pupkin", 23));
	}

	@Test
	public void test_get_many() 
	{
		hTable.init(ini_many);
		Person exp =ini_many[0];
		assertEquals(exp, hTable.get(ini_many[0].hashCode()));
	}
	@Test
	public void test_get_two() 
	{
		hTable.init(ini_two);
		Person exp = ini_two[0];
		assertEquals(exp, hTable.get(ini_two[0].hashCode()));
	}
	@Test
	public void test_get_one() 
	{
		hTable.init(ini_one);
		Person act = hTable.get(ini_one[0].hashCode());
		assertEquals(ini_one[0], act);
	}
	@Test(expected=IllegalArgumentException.class)
	public void test_get_null() 
	{
		hTable.init(ini_null);
		hTable.get(new Person(10, "Vasia", "Pupkin", 		23));
	}

	@Test
	public void test_put_many() 
	{
		hTable.init(ini_many);
		hTable.put( new Person(66, "Jurii","Malyarchuk", 	40) );
		hTable.put( new Person(91, "Anna", "trembach",		30) );
		hTable.put( new Person(74, "Sveta","Gavrilenko",	31) );
		hTable.put( new Person(86, "nastja","Hitraja",		30) );
		Person[] act = hTable.toArray();
		Person[] exp = {
				new Person (12, "Volodya", 	"Kovalevskij", 		23),
				new Person (51, "boris", 	"Tkachuk", 			17),
				new Person (17, "Masia", 	"Gupkin", 			19),
				new Person (33, "Gasia", 	"Hupkin", 			56),
				new Person (62, "Anton", 	"Kobilko", 			82),
				new Person (22, "Aleksey", 	"Abrosimov", 		62),
				new Person (60, "Lasia", 	"Jupkin", 			99),
				new Person (34, "Sergey", 	"Shevchenko", 		25),
				new Person (14, "Kasia", 	"Lupkin", 			27),
				new Person (71, "Andrey", 	"Petrishe", 		12),
				new Person (18, "Evgenii", 	"Lopateckii",		75),
				new Person (10, "Vasia", 	"Pupkin", 			23),
				new Person(66, "Jurii",		"Malyarchuk", 		40),
				new Person(91, "Anna", 		"trembach",			30),
				new Person(74, "Sveta",		"Gavrilenko",		31),
				new Person(86, "nastja",	"Hitraja",			30)
		};
		assertEquals(exp.length, act.length);
	}
	@Test
	public void test_put_two() 
	{
		hTable.init(ini_two);
		Person p = new Person(86, "nastja","Hitraja",30);
		hTable.put( p );
		Person[] act = hTable.toArray();
		Person[] exp = {
				new Person(14, "Kasia", "Lupkin", 27),
				new Person(10, "Vasia", "Pupkin", 23),p};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_put_one() 
	{
		hTable.init(ini_one);
		Person p = new Person(86, "nastja","Hitraja",30);
		hTable.put( p);
		Person[] act = hTable.toArray();
		Person[] exp = {
				new Person(10, "Vasia", "Pupkin", 23),p};
		assertArrayEquals(exp, act);
	}
	@Test
	public void test_put_null_person() 
	{
		hTable.init(ini_null);
		Person p =  new Person(86, "nastja","Hitraja",30);
		hTable.put(p);
		Person[] act = hTable.toArray();
		Person[] exp = {p};
		assertArrayEquals(exp, act);
	}


	@Test
	public void test_clear_many() 
	{
		hTable.init(ini_many);
		hTable.clear();
		int exp = hTable.size();
		assertEquals(exp, 0);
	}
	@Test
	public void test_clear_two() 
	{
		hTable.init(ini_two);
		hTable.clear();
		int exp = hTable.size();
		assertEquals(exp, 0);
	}
	@Test
	public void test_clear_one() 
	{
		hTable.init(ini_one);
		hTable.clear();
		int exp = hTable.size();
		assertEquals(exp, 0);
	}
	@Test
	public void test_clear_null() 
	{
		hTable.init(ini_null);
		hTable.clear();
		int exp = hTable.size();
		assertEquals(exp, 0);
	}


	@Test
	public void test_size_many() 
	{
		hTable.init(ini_many);
		int exp = hTable.size();
		int act = 12;
		assertEquals(exp, act);
	}
	@Test
	public void test_size_two() 
	{
		hTable.init(ini_two);
		int exp = hTable.size();
		int act = 2;
		assertEquals(exp, act);
	}
	@Test
	public void test_size_one() 
	{
		hTable.init(ini_one);
		int exp = hTable.size();
		int act = 1;
		assertEquals(exp, act);
	}
	@Test
	public void test_size_null() 
	{
		hTable.init(ini_null);
		int exp = hTable.size();
		int act = 0;
		assertEquals(exp, act);
	}
}
