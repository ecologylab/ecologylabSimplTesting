package ecologylab.testing.serialization;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.formatenums.StringFormat;

public class ClassDescriptorGenericInformation {

	
	
	@Test
	public void assertThatTheErasureProducesEquivilantClassesForDifferentTypeParameters()
	{
		SingleGenericParameterExample<Double> exampleOne = new SingleGenericParameterExample(1.0);
		SingleGenericParameterExample<String> exampleTwo = new SingleGenericParameterExample("STRING");
		SingleGenericParameterExample<?> wildcarded = new SingleGenericParameterExample(new File("C:\\dev\\EXAMPLE"));

		Class<?> one = exampleOne.getClass();
		Class<?> two = exampleTwo.getClass();
		Class<?> wildCard = wildcarded.getClass();
		
		assertTrue(one.equals(two));
		assertTrue(two.equals(wildCard));
		assertTrue(wildCard.equals(one));
		/// WHY DOES THIS MATTER?
		// -----------------------
		// Since the class descriptor is made with a class
		// and since the classes for differing types will all be the same
		// the class descriptor will not adequately differentiate between classes
		// So we don't have the proper information.
		
	}
	
	@Test
	public void assertThatTheErasureRemovesRelevantTypeInformationFromTheField()
	{
		SingleGenericParameterExample<Double> exampleOne = new SingleGenericParameterExample(1.0);
		
		Class<?> one = exampleOne.getClass(); 
		
		Field valueField = one.getDeclaredFields()[0];
		assertFalse(valueField.getType() == Double.class); // The field is not a Double... Because the type is erased
		assertTrue(valueField.getType() == Object.class); // It is an object.
	
		Class<?> result = valueField.getGenericType().getClass(); // And even if you try asking differently, you'll still view it as an object.	}
		assertNotNull(result);
	
	}
	
	
	@Test
	public void InternalGenricsSerializeDeserializeTest() throws SIMPLTranslationException
	{
		InternalGenerics ig = new InternalGenerics(1.3);
		
		SerializeDeserializeAndAssertEquals(ig);
	}
	
	public class DoubleExample
	{
		@simpl_scalar
		Double value;
		
		public DoubleExample(Double v)
		{
			this.value = v;
		}
	
	}
	
	@Test
	public void getDescription()
	{
		SingleGenericParameterExample<Double> exampleOne = new SingleGenericParameterExample(1.0);

		ClassDescriptor<?> cd = ClassDescriptor.getClassDescriptor(exampleOne.getClass());
		List<?> list = cd.getGenericTypeVars();
		
		
		SingleGenericParameterExample<ClassDescriptor<?>> exampleTwo =new SingleGenericParameterExample<ClassDescriptor<?>>();		
		ClassDescriptor<?> cd2 = ClassDescriptor.getClassDescriptor(exampleTwo.getClass());
		List<?> list2 = cd2.getGenericTypeVars();
	
		System.out.println(":");
	}
	
	@Test
	public void testGenericSerializationDeserializationWithSingleGenericParameter() throws SIMPLTranslationException
	{
		SingleGenericParameterExample<Double> exampleOne = new SingleGenericParameterExample(1.0);
		SingleGenericParameterExample<String> exampleTwo = new SingleGenericParameterExample("STRING");
		SingleGenericParameterExample<?> wildcarded = new SingleGenericParameterExample(new File("C:\\dev\\EXAMPLE"));
		
		SerializeDeserializeAndAssertEquals(exampleOne);
		SerializeDeserializeAndAssertEquals(exampleTwo);
		SerializeDeserializeAndAssertEquals(wildcarded);
	}
	
	public void SerializeDeserializeAndAssertEquals(Object original) throws SIMPLTranslationException
	{
		SimplTypesScope.serialize(original,System.out, StringFormat.XML);	
		StringBuilder serialized = SimplTypesScope.serialize(original, StringFormat.XML);
		Object Deserialized = exampleTransloScope.get().deserialize(serialized.toString(), StringFormat.XML);
		Assert.assertNotNull("Object not serialized", serialized.toString());
		Assert.assertNotNull("Object Not Deserialized", Deserialized);
		Assert.assertTrue("Original not equal to deserialized version", original.equals(Deserialized));
	}
	
	@Test
	public void testThreeParameterSerializationDeserialization() throws SIMPLTranslationException {
		GenericExample<Integer, Double, String> exampleOne = new GenericExample<Integer, Double, String>(13, 1.3, "13");
		GenericExample<File, String, Double> exampleTwo = new GenericExample<File, String, Double>(new File("C:\\dev\\EXAMPLE"), "EXAMPLE", 1.3);	
		GenericExample<?,?,?> WILDCARDS = new GenericExample<String, String, String>("getting", "wild", "here");
	
		SerializeDeserializeAndAssertEquals(exampleOne);
		SerializeDeserializeAndAssertEquals(exampleTwo);
		SerializeDeserializeAndAssertEquals(WILDCARDS);		
	}
	
}
