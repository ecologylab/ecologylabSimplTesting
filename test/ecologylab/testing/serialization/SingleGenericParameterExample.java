package ecologylab.testing.serialization;

import java.lang.reflect.Field;

import ecologylab.serialization.annotations.simpl_scalar;

public class SingleGenericParameterExample<T>
{
	
	
	@simpl_scalar
	T value;
	
	Double somethingElse;
	
	public SingleGenericParameterExample()
	{
		
	}
	
	
	public SingleGenericParameterExample(T t)
	{
		this.value = t;
		this.somethingElse  =1.4;
		Field[] fields = this.getClass().getDeclaredFields();		
		System.out.println();
	}
	
	public T getTee() {
		return value;
	}

	public void setTee(T tee) {
		this.value = tee;
	}

	@Override
	public String toString()
	{
		return value.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		if(other instanceof SingleGenericParameterExample)
		{
			return this.value.equals(((SingleGenericParameterExample)other).getTee());
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