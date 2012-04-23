package ecologylab.testing.serialization;


import java.lang.reflect.Field;

import org.junit.Test;


public class GenericProblems {

	
	@Test
	public void test() {

		rootGeneric<?> g = new rootGeneric<Double>(1.0);
		rootGeneric<?> g1 = new rootGeneric<String>("String!");
		rootGeneric<?> g2 = new rootGeneric<T_Grade>(new T_Grade("1",1.0));
		
		System.out.println("inh---------------");

		

		inhGen<?> ig = new inhGen<Double>(1.0);
		inhGen<?> ig1 = new inhGen<String>("String!");
		inhGen<?> ig2 = new inhGen<T_Grade>(new T_Grade("1",1.0));

		
		System.out.println("empty------------");
		inhGen<?> ig11 = new inhGen<Double>();
		inhGen<?> ig144 = new inhGen<String>();
		inhGen<?> ig244 = new inhGen<T_Grade>();
		
		System.out.println("fielding it");
		for(Field f : ig11.getClass().getDeclaredFields())
		{
			System.out.println(f.getAnnotations() == null ? "null" : f.getAnnotations().length);
			
		}
	}

}
