package ecologylab.testing.serialization;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.formatenums.StringFormat;

public class ClassDescriptorGenericInformation {

	@Test
	public void InternalGenricsTest() throws SIMPLTranslationException
	{
		InternalGenerics ig = new InternalGenerics(1.3);
		
		SimplTypesScope.serialize(ig,System.out, StringFormat.XML);
		StringBuilder resultOne = SimplTypesScope.serialize(ig, StringFormat.XML);
		
		InternalGenerics result = (InternalGenerics) exampleTransloScope.get().deserialize(resultOne.toString(), StringFormat.XML);
		Assert.assertTrue(ig.equals(result));
	}
	
	@Test
	public void testWithJustOne() throws SIMPLTranslationException
	{
		SingleExample<Double> exampleOne = new SingleExample(1.0);
		SingleExample<String> exampleTwo = new SingleExample("STRING");
		SingleExample<?> wildcarded = new SingleExample(new File("C:\\dev\\EXAMPLE"));
		
		SimplTypesScope.serialize(exampleOne,System.out, StringFormat.XML);
		StringBuilder resultOne = SimplTypesScope.serialize(exampleOne, StringFormat.XML);
		
		SingleExample<?> result = (SingleExample<?>) exampleTransloScope.get().deserialize(resultOne.toString(), StringFormat.XML);
		Assert.assertNotNull(resultOne);
		Assert.assertNotNull(result);
		Assert.assertTrue(exampleOne.equals(result));
	}
	
	@Test
	public void test() throws SIMPLTranslationException {

		GenericExample<Integer, Double, String> exampleOne = new GenericExample<Integer, Double, String>(13, 1.3, "13");
		
		GenericExample<File, String, Double> exampleTwo = new GenericExample<File, String, Double>(new File("C:\\dev\\EXAMPLE"), "EXAMPLE", 1.3);
		
		GenericExample<?,?,?> WILDCARDS = new GenericExample<String, String, String>("getting", "wild", "here");
	
		ClassDescriptor<?> oneCD = ClassDescriptor.getClassDescriptor(exampleOne.getClass());
		ClassDescriptor<?> twoCD = ClassDescriptor.getClassDescriptor(exampleTwo.getClass());
		ClassDescriptor<?> wildCD = ClassDescriptor.getClassDescriptor(WILDCARDS.getClass());
		
		List<?> typeOne = oneCD.getGenericTypeVars();
		List<?> typeTwo = twoCD.getGenericTypeVars();
		List<?> typeThree = wildCD.getGenericTypeVars();

		System.out.println("oh hi");
		
		SimplTypesScope.serialize(exampleTwo, System.out, StringFormat.XML);
		StringBuilder result = SimplTypesScope.serialize(exampleTwo, StringFormat.XML);
		

		 StringBuilder serializedOne = exampleTransloScope.get().serialize(exampleOne,StringFormat.XML);
		 
		GenericExample<Integer,Double,String> resultOne = (GenericExample<Integer,Double,String>)exampleTransloScope.get().deserialize(serializedOne.toString(), StringFormat.XML);
		
		 Assert.assertTrue(exampleOne.equals(resultOne));
		 
		
	}

}
