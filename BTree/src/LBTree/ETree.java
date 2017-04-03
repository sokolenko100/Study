package LBTree;

public interface ETree extends Iterable<Integer>
{
	void init(int[] tempArray);
	void add(int val);
	void clear();
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
