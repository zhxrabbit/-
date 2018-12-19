package Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import T.T3;

public class T3Test {

	@Test
	public void testAdd() {
		int n=new T3().add(4,8);
		//allOf匹配符表明如果接下来的所有条件必须都成立测试才通过
		assertThat(n,allOf(greaterThan(1),lessThan(17)));
		//anyOf匹配符表明如果接下来的所有条件只要有一个成立则测试通过
		assertThat(n,anyOf(greaterThan(7),lessThan(7)));
		//anything匹配符表明无论什么条件，永远为true
		assertThat(n,anything());
		//is匹配符表明如果前面待测的object等于后面给出的object，则测试通过
		assertThat(n,is(12));
		//not匹配符和is匹配符正好相反，表明如果前面待测的object不等于后面给出的object，则测试通过
		assertThat(n,not(12));
	}
}
