package wan.cloud.note.test;

import java.lang.reflect.Method;

import org.junit.Test;

import wan.cloud.note.entity.User;

public class TestIOC {

	/**
	 * IOC反射
	 * @throws Exception
	 */
	@Test
	public void test1()throws Exception{
		String classname="wan.cloud.note.entity.User";
		Class clazz=Class.forName(classname);
		Object obj=clazz.newInstance();
		Method method=clazz.getMethod("setCn_user_name", String.class);
		System.out.println(method);
		method.invoke(obj, "demo");
		User user=(User)obj;
		
	}
}
