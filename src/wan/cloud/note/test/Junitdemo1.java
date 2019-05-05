package wan.cloud.note.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)//该类是一个junit套件，可以同时运行多个测试类
//@SuiteClasses({//类})/////
public class Junitdemo1 {

	@Before//每次调用测试方法前都会执行此方法一遍
	public void test() {
		fail("Not yet implemented");
		//Assert//断言测试逻辑
	}
	@Test
	public void test1(){
		System.out.println("测试1");
	}
	@After//每次调用测试方法之后调用此方法
	public void test2(){
		System.out.println("释放资源");
	}
	

}
