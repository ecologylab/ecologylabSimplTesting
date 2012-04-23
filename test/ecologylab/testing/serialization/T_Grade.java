package ecologylab.testing.serialization;

import java.util.ArrayList;
import java.util.List;

import ecologylab.serialization.annotations.simpl_scalar;

public class T_Grade {

		@simpl_scalar
		String name;
		
		@simpl_scalar
		Double value;
		
		@simpl_scalar
		Double maxValue;
		
		
		private T_Grade(String n, Double mV, Double d)
		{
			this.name = n;
			this.maxValue = mV;
			this.value = d;
		}
		
		public T_Grade(String n, Double mV)
		{
			this.value = 0.0;
			this.name = n;
			this.maxValue = mV;
		}
		
		public static List<T_Grade> defaultCriteria()
		{
			List<T_Grade> grades = new ArrayList<T_Grade>();
			grades.add(new T_Grade("Rich Bookmarks",3.0));
			grades.add(new T_Grade("Visual Presentation",3.0));
			grades.add(new T_Grade("Relevance",3.0));
			grades.add(new T_Grade("Emergence",3.0));
			grades.add(new T_Grade("Exposition",3.0));
			return grades;
		}
		
		public T_Grade createGrade(Double d)
		{
			return new T_Grade(this.name, this.maxValue, d);
		}

		public String name()
		{
			return this.name;
		}
		
		public Double score()
		{
			return this.value;
		}
		
		public Double max()
		{
			return this.maxValue;
		}
}
