package rw;

import java.util.*;
import ValuableFactory.*;


	public class Treasureroom {
		private ArrayList<Valuable> valuables = new ArrayList<Valuable>();	
		
		public Valuable getValueWriter()
		{
			return valuables.remove(0);
		}
		
		
		public void updateValue(Valuable valuable)
		{
			valuables.add(valuable);
		}
		
		public boolean removeValue(Valuable valuable)
		{
			return valuables.remove(valuable);
		}
		
		public Valuable getValueRead()
		{
			for (int i=0; i<valuables.size();i++)
			{
				return valuables.get(i); 
			}
			return null;
		}	
	}