package Test;

import org.junit.Test;

import static org.junit.Assert.*;

import T.T1;

public class T1Test {

	@Test
	public void testAdd() {
		T1 a=new T1();
		int s=a.add(3, 5);
		assertEquals(8,a.add(3,5));
		assertTrue(s>3);
		assertTrue("s is too small",s<10);
	}
}
