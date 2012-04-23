package ecologylab.testing.serialization;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import ecologylab.serialization.annotations.simpl_generic;

public class rootGeneric<GenType>{
	
	@simpl_generic(String.class)
	protected GenType type;
	
	public rootGeneric(GenType g)
	{
		this.type = g;
		printInstanceOfs();
	}
	
	public rootGeneric()
	{
		
		printInstanceOfs();
	}
	
	
	public void printInstanceOfs()
	{
		System.out.println("=====This Class");
		System.out.println(this.getClass().getName());

		if(this.type != null)
		{
			System.out.println("====Class");
			System.out.println(this.type.getClass().getName());
			System.out.println("====instofs");

			
			if(this.type instanceof Object)
			{
				System.out.println("Object");
			}
			
			if(this.type instanceof Double)
			{
				System.out.println("Double");
			}
			
			if(this.type instanceof String)
			{
				System.out.println("String");
			}
		}
		
		for(Field f : this.getClass().getDeclaredFields())
		{
			System.out.println(f.getName());
			for(Annotation anno : f.getAnnotations())
			{
				System.out.println(anno.getClass().getName());					
			}
				
			if(f.isAnnotationPresent(simpl_generic.class))
			{
				simpl_generic sg = f.getAnnotation(simpl_generic.class);
				System.out.println(f.getName() + " | " + sg.value().getName());
			}
		}
	}
	
}