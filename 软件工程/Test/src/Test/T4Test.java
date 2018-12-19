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
		//containsString匹配符表明如果测试的字符串str包含子字符串"test"则测试通过
		assertThat(str,containsString("test"));
		//endsWith匹配符表明如果测试的字符串str以子字符串"ss"结尾则测试通过
		assertThat(str,endsWith("ss"));
		//startsWith匹配符表明如果测试的字符串str以子字符串"testsucc"开始则测试通过
		assertThat(str,startsWith("testsucc"));
		// equalTo匹配符表明如果测试的str等于str2则测试通过
		assertThat(str,equalTo(str2));
		//equalToIgnoringCase匹配符表明如果测试的字符串str在忽略大小写的情况下等于"TestSuccess"则测试通过
		assertThat(str,equalToIgnoringCase("TestSuccess"));
		//equalToIgnoringWhiteSpace匹配符表明如果测试的字符串str在忽略头尾的任意个空格的情况下等于"   testsuccess    "则测试通过
		assertThat( str, equalToIgnoringWhiteSpace( "   TestSuccessed    " ) );
	}	
}
