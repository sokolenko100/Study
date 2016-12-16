package LLists;
public interface EList 
{
	void clear();
	int  size();
	void init(int[] rr);
	int[] toArray();
	String toString();

	void addStart(int val);
	void addEnd(int val);
	void addPos(int pos, int val);
	
	int delStart();
	int delEnd();
	int delPos(int pos);
	
	int get(int pos);
	void set(int pos, int val);
	
	int min();
	int max();
	int minPos();
	int maxPos();
	
	void sort();
	void reverse();
	void halfReverse();
}
