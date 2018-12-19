package Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import T.T4;

public class T4Test {

	@Test
	public void testGetName() {
		String str=new T4().getName();
		String str2="testsuccess";
		//containsStringƥ�������������Ե��ַ���str�������ַ���"test"�����ͨ��
		assertThat(str,containsString("test"));
		//endsWithƥ�������������Ե��ַ���str�����ַ���"ss"��β�����ͨ��
		assertThat(str,endsWith("ss"));
		//startsWithƥ�������������Ե��ַ���str�����ַ���"testsucc"��ʼ�����ͨ��
		assertThat(str,startsWith("testsucc"));
		// equalToƥ�������������Ե�str����str2�����ͨ��
		assertThat(str,equalTo(str2));
		//equalToIgnoringCaseƥ�������������Ե��ַ���str�ں��Դ�Сд������µ���"TestSuccess"�����ͨ��
		assertThat(str,equalToIgnoringCase("TestSuccess"));
		//equalToIgnoringWhiteSpaceƥ�������������Ե��ַ���str�ں���ͷβ��������ո������µ���"   testsuccess    "�����ͨ��
		assertThat( str, equalToIgnoringWhiteSpace( "   TestSuccessed    " ) );
	}	
}
