package ar.edu.ub.testing.memotest.testcase;

import ar.edu.ub.testing.utils.ArrayUtils;
import junit.framework.TestCase;

public class TestArrayUtils extends TestCase 
{
	public void testMezclarNull()
	{
		assertEquals( ArrayUtils.mezclar( null ), null );
	}
	
	public void testMezclarVacio()
	{
		String[] s = new String[] { null, null, null };
		assertEquals( ArrayUtils.mezclar( s ), null );
	}	
}
