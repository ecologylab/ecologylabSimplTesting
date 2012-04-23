package ecologylab.testing.serialization;

import ecologylab.serialization.annotations.simpl_scalar;

public class SingleExample<T>
{
	
	
	@simpl_scalar
	T tee;
	
	public SingleExample()
	{
		
	}
	
	public SingleExample(T t)
	{
		this.tee = t;
	}
	
	public T getTee() {
		return tee;
	}

	public void setTee(T tee) {
		this.tee = tee;
	}

	@Override
	public String toString()
	{
		return tee.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		if(other instanceof SingleExample)
		{
			return this.tee.equals(((SingleExample)other).getTee());
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return 42; // I'm going to be that guy and do this. (Again!)
	}
	
}