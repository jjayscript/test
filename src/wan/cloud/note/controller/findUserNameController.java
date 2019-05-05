package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.userService;

@Controller
@RequestMapping("/note")
public class findUserNameController {

	@Resource
	private userService uService;
	@RequestMapping("/findname.do")
	@ResponseBody
	public noteresult findname(String userid,String password) throws Exception{
		noteresult result=new noteresult();
		result=uService.find_username(userid,password);
		return result;
	}
}
