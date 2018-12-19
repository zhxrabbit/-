package Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import T.T6;

public class T6Test {
	/*
	@Before
	public void before() {
		System.out.println("before");
	}
	*/
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}
	@Test
	public void testSub() {
		int d=new T6().sub(10, 6);
		assertThat(d,is(4));
		assertThat(d,allOf(greaterThan(3),lessThan(5)));
	}
	@After
	public void After() {
		System.out.println("after");
	}
	@AfterClass
	public static void AfterClass() {
		System.out.println("afterClass");
	}
}
