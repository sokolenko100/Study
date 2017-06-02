package data;

import java.util.HashMap;

import modules.IModule;

public class SingletonDBModule {
	private volatile static	HashMap<String, IModule> modules = new HashMap();

	public static class InnerClass
	{
		public static SingletonDBModule module = new SingletonDBModule();
	}
	public static SingletonDBModule getInstance()
	{
		return InnerClass.module;
	}
	
	public synchronized void addModule(String key, IModule module)
	{
		modules.put(key, module);
	}
	public synchronized IModule getModule(String key)
	{
		return modules.get(key);
	}
	public synchronized void removeModule(String key)
	{
		 modules.remove(key);
	}
}
