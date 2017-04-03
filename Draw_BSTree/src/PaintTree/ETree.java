package PaintTree;

public interface ETree
{
	void init(int[] tempArray);
	void add(int val);
	int size();
	int nodes();
	int leaves();
	int height();
	int width();
	void reverse();
	void del(int val);
	int[] toArray();
	String toString();
}
