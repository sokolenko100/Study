package HashTable;

import model.Person;

public interface EHashTable
{
//  init / clear/ size / put / del / get / toArray
	void init(Person [] temp);
	void clear();
	int size();
	void put(Person p);
	Person del(Person p);
	Person get(Person p);
	Person[] toArray();
}
