package messanger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingletonMessager
{
	private volatile static	List<String> answer = Collections.synchronizedList(new ArrayList<String>());

	public static class InnerClass
	{
		public static SingletonMessager masseges = new SingletonMessager();
	}
	public static SingletonMessager getInstance()
	{
		return InnerClass.masseges;
	}
	public int Size()
	{
		return	answer.size();
	}
	public synchronized void addMassege(String massege)
	{
		answer.add(massege);
	}
	public synchronized String getMassege(int index)
	{
		return answer.get(index);
	}
	public synchronized void removeMassege(int index)
	{
		answer.remove(index);
	}
}
