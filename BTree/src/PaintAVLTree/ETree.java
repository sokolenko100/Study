package PaintAVLTree;

public interface ETree extends Iterable<Integer>
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
