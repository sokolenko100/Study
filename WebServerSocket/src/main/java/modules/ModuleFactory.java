package modules;

import data.SingletonDBModule;
import java.lang.*;
public class ModuleFactory
{
	SingletonDBModule dbmodules = null;
	public ModuleFactory() 
	{
		dbmodules = SingletonDBModule.getInstance();
	}

	public IModule CheckModule(String nameModule)
	{
		String path = "modules." + nameModule;
		IModule result = null;

		result =  dbmodules.getModule(nameModule);
		if(result==null)
		{
			try {
				result =(IModule) Class.forName(path).newInstance();
			} catch (InstantiationException e)
			{
				//e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{

			}
			catch (ClassNotFoundException e)
			{

			}
		}
		if(result != null)
		{
			dbmodules.addModule(nameModule, result);
		}
		return result;
	}
}
