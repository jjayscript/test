package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.userService;

@Controller
@RequestMapping("/user")
public class changePasswordController {

	@Resource
	private userService uService;
	@RequestMapping("/changepassword.do")
	@ResponseBody
	public noteresult changepassword(String userid,String password)throws Exception{
		noteresult result=new noteresult();
		result=uService.modify_password(userid, password);
		return result;
	}
}
