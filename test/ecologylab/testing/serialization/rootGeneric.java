package ecologylab.testing.serialization;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class rootGeneric<GenType>{
	
	protected GenType type;
	
	public rootGeneric(GenType g)
	{
		this.type = g;
	}
	
	public rootGeneric()
	{}
	
	
}