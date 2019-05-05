package wan.cloud.note.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.userService;

public class Junitdemo2 {

	@Test
	public void test1() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext aContext=new ClassPathXmlApplicationContext("configApplication.xml");
		userService service= aContext.getBean("userAction",userService.class);
		noteresult result=service.checklogin("demo", "1234");
		Assert.assertEquals(0, result.getStatus());
		//Assert.assertEquals("密码不对", result.getMsg());
	}
}
