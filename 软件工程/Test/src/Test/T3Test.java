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
		//allOfƥ�����������������������������붼�������Բ�ͨ��
		assertThat(n,allOf(greaterThan(1),lessThan(17)));
		//anyOfƥ��������������������������ֻҪ��һ�����������ͨ��
		assertThat(n,anyOf(greaterThan(7),lessThan(7)));
		//anythingƥ�����������ʲô��������ԶΪtrue
		assertThat(n,anything());
		//isƥ����������ǰ������object���ں��������object�������ͨ��
		assertThat(n,is(12));
		//notƥ�����isƥ��������෴���������ǰ������object�����ں��������object�������ͨ��
		assertThat(n,not(12));
	}
}
