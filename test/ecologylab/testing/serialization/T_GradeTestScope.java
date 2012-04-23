package ecologylab.testing.serialization;

import ecologylab.serialization.SimplTypesScope;
import ecologylab.textformat.NamedStyle;

public class T_GradeTestScope {

	public static final String SCOPE_NAME		= "t_grade_test_scope";
	
	public static final SimplTypesScope INHERITED_TRANSLATIONS[] = 
	{
		SimplTypesScope.getBasicTranslations()
	};
	
	public static final Class	TRANSLATIONS[]	= 
	{ 
		T_Grade.class
	};
	
	public static SimplTypesScope get()
	{
		return SimplTypesScope.get(SCOPE_NAME, INHERITED_TRANSLATIONS, TRANSLATIONS);
	}	
}
