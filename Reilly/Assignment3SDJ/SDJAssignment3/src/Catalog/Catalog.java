package Catalog;

//Singleton class
public class Catalog implements CatalogInterface
{
	private static Catalog instance; 

	private Catalog()
	{
	 //Nothing 	
	}
	
	public static Catalog getInstance()
	{
		if (instance == null)
		{
			instance = new Catalog();
		}
		return instance;
	}

	@Override
	public void addLog(String log) 
	{
		System.out.println(log);
	}

}