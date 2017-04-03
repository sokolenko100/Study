package Alist_itterator;
public interface EList <T>
{
	void clear();
	int  size();
	void init(T[] rr);
	<T>	T[] toArray();

	void addStart(T val);
	void addEnd(T val);
	void addPos( T val,int pos);

	<T>	T delStart();
	<T>	T delEnd();
	<T>	T delPos(int pos);

	<T>	T get(int pos);
	void set( T val,int pos);

	<T>	T min();
	<T>	T max();
	int minPos();
	int maxPos();

	void sort();
	void reverse();
	void halfReverse();
}
