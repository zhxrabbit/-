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
		//closeToƥ���������������Եĸ�������c��20.0��0.5��Χ֮�������ͨ��
		assertThat(c,closeTo(24.0,4.0));
		//greaterThanƥ���������������Ե���ֵc����16.0�����ͨ��
		assertThat(c,greaterThan(20.0));
		//lessThanƥ���������������Ե���ֵcС��16.0�����ͨ��
		assertThat(c,lessThan(30.0));
		//greaterThanOrEqualToƥ���������������Ե���ֵc���ڵ���16.0�����ͨ��
		assertThat(c,greaterThanOrEqualTo(28.0));
		//lessThanOrEqualToƥ���������������Ե���ֵcС�ڵ���16.0�����ͨ��
		assertThat(c,lessThanOrEqualTo(25.0));
	}

}

