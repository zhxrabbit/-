package Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import T.T5;

public class T5Test {

	@Test
	public void testMult() {
		double c=new T5().mult(4,7);
		//closeTo匹配符表明如果所测试的浮点型数c在20.0±0.5范围之内则测试通过
		assertThat(c,closeTo(24.0,4.0));
		//greaterThan匹配符表明如果所测试的数值c大于16.0则测试通过
		assertThat(c,greaterThan(20.0));
		//lessThan匹配符表明如果所测试的数值c小于16.0则测试通过
		assertThat(c,lessThan(30.0));
		//greaterThanOrEqualTo匹配符表明如果所测试的数值c大于等于16.0则测试通过
		assertThat(c,greaterThanOrEqualTo(28.0));
		//lessThanOrEqualTo匹配符表明如果所测试的数值c小于等于16.0则测试通过
		assertThat(c,lessThanOrEqualTo(25.0));
	}

}

