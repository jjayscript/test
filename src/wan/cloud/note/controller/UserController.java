package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.service.userService;
import wan.cloud.note.entity.noteresult;
@Controller
@RequestMapping("/user")
@Transactional
public class UserController {

	@Resource
	private userService uService;
	@RequestMapping("/login.do")
	@ResponseBody
	public noteresult login(String name,String pwd) throws Exception{
		noteresult result=new noteresult();
		System.out.println(uService.getClass());
		result=uService.checklogin(name, pwd);
		return result;
	}
	
	
}
