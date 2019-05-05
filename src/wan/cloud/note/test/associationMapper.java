package wan.cloud.note.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wan.cloud.note.DAO.UserDao;
import wan.cloud.note.entity.User;
import wan.cloud.note.entity.cn_notebook;

public class associationMapper {

	
	
	public static void main(String[] args) {
		ApplicationContext aContext=new ClassPathXmlApplicationContext("configApplication.xml");
		UserDao dao=aContext.getBean("userDao",UserDao.class);
		User user=dao.finduser("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(user.getCn_user_name());
		System.out.println(user.getBooks());
		List<cn_notebook>notebooks=dao.findallbook();
		System.out.println(notebooks);
	}
}
