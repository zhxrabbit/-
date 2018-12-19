package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import T.T2;

public class T2Test {

	@Test
	public void testDivide() {
		T2 b=new T2();
		int s=b.divide(8,4);
		assertEquals(2,b.divide(8,4));
		assertTrue(s<5);
		assertTrue("s is too small",s>10);
	}

	@Test
	public void testGetName() {
		T2 name=new T2();
		assertEquals("ҹݺ",name.getName());
	}

}
