package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;

import wan.cloud.note.service.userService;
@Controller
@RequestMapping("/user")
public class registController {

	@Resource
	private userService uService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public noteresult register(String name,String nickname,String pwd) throws Exception{
		noteresult result=new noteresult();
		result=uService.regist(name, nickname, pwd);
		return result;
	}
	
}
