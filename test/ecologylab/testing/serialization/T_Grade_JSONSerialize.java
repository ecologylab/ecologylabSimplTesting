package ecologylab.testing.serialization;

import org.junit.Test;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.formatenums.StringFormat;

public class T_Grade_JSONSerialize {

	@Test
	public void test() throws SIMPLTranslationException {
		
		T_Grade testIt = new T_Grade("test", 3.0);
		T_Grade toSerialize = testIt.createGrade(1.0);
		
		StringBuilder result = new StringBuilder();
		T_GradeTestScope.get().serialize(toSerialize, result, StringFormat.JSON);
		
		String actual = result.toString();
		System.out.println(actual);
	}

}
