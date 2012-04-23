package ecologylab.testing.serialization;

import java.util.ArrayList;
import java.util.List;

import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_scalar;

/**
 * Note, this class is *not* generic
 * @author twhite
 *
 */
public class InternalGenerics
{
	
	public InternalGenerics()
	{
		
	}
	
	@simpl_collection("dubs")
	List<Double> Dubs;
	
	@simpl_scalar
	Class<String> stringClass; 
	
	public InternalGenerics(Double dub)
	{
		Dubs = new ArrayList<Double>();
		Dubs.add(dub);
		stringClass = String.class;
	}
	
	public List<Double> getDubs()
	{
		return Dubs;	
	}

	public void setDubs(List<Double> d)
	{
		this.Dubs = d;
	}
	
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		if(other instanceof InternalGenerics)
		{
			InternalGenerics ig = (InternalGenerics)other;
			if(ig.getDubs().size() == this.Dubs.size())
			{
				for(int i = 0; i < Dubs.size(); i++)
				{
					if(!ig.getDubs().get(i).equals(this.Dubs.get(i)))
					{
						return false;
					}
				}
				return true;
				
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
}