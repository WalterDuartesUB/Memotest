package ar.edu.ub.testing.memotest.testcase;

import ar.edu.ub.testing.utils.StringUtils;
import junit.framework.TestCase;

public class TestStringUtils extends TestCase 
{

	public void testIsEmptyNull()
	{						
		assertTrue( StringUtils.isEmpty( null ) );
	}
		
	public void testIsEmptyVacio()
	{						
		assertTrue( StringUtils.isEmpty( "" ) );
	}
		
	public void testIsEmptyConLetras()
	{						
		assertFalse( StringUtils.isEmpty( "asd" ) );
	}
	
	public void testIsEmptyConNumeros()
	{						
		assertFalse( StringUtils.isEmpty( "123" ) );
	}

	public void testIsNumericNull()
	{						
		assertFalse( StringUtils.isNumeric( null ) );
	}
	
	public void testIsNumericVacio()
	{						
		assertFalse( StringUtils.isNumeric( "" ) );
	}	
			
	public void testIsNumericConLetras()
	{						
		assertFalse( StringUtils.isNumeric( "asd" ) );
	}
	
	public void testIsNumericConNumeros()
	{						
		assertTrue( StringUtils.isNumeric( "123" ) );
	}
	
}