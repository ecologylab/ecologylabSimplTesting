package ecologylab.testing.serialization;

import ecologylab.serialization.annotations.simpl_scalar;

public class GenericExample<X,Y,Z>
{
	
	
	@simpl_scalar
	X ecks;
	
	@simpl_scalar
	Y why;
	
	@simpl_scalar
	Z zee;
	
	public GenericExample()
	{
		
	}

	public GenericExample(X x, Y y, Z z)
	{
		this.ecks = x;
		this.why = y;
		this.zee = z;
	}

	public X getEcks() {
		return ecks;
	}

	public void setEcks(X ecks) {
		this.ecks = ecks;
	}

	public Y getWhy() {
		return why;
	}

	public void setWhy(Y why) {
		this.why = why;
	}

	public Z getZee() {
		return zee;
	}

	public void setZee(Z zee) {
		this.zee = zee;
	}

	
	@Override
	public String toString()
	{
		return ecks.toString() + " | " + why.toString() + " | " + zee.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		if(other instanceof GenericExample)
		{
			GenericExample ge = (GenericExample)other;
			if(ecks.equals(ge.getEcks()))
			{
				if(why.equals(ge.getWhy()))
				{
					if(zee.equals(ge.getZee()))
					{
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return 42; // I'm going to be that guy and do this. 
	}
}