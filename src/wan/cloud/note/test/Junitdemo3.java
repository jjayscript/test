package wan.cloud.note.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wan.cloud.note.DAO.UserDao;
import wan.cloud.note.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:configApplication.xml")
public class Junitdemo3 extends AbstractJUnit4SpringContextTests{

	@Resource
	private UserDao dao;
	@Test
	public void test1() {
		User user=new User();
		user=dao.findByName("demo");
		Assert.assertNotNull(user);
	}

}
