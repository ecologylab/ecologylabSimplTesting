package ecologylab.testing.serialization;

import ecologylab.serialization.SimplTypesScope;

public class exampleTransloScope
{
	public static final String SCOPE_NAME		= "t_grade_test_scope";
	
	public static final SimplTypesScope INHERITED_TRANSLATIONS[] = 
	{
		SimplTypesScope.getBasicTranslations()
	};
	
	public static final Class	TRANSLATIONS[]	= 
	{ 
		GenericExample.class, 
		SingleExample.class,
		InternalGenerics.class
	};
	
	public static SimplTypesScope get()
	{
		return SimplTypesScope.get(SCOPE_NAME, INHERITED_TRANSLATIONS, TRANSLATIONS);
	}			
}