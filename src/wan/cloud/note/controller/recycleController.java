package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class recycleController {

	@Resource
	private noteService nService;
	@RequestMapping("/recycle.do")
	@ResponseBody
	public noteresult renote(String userid){
		noteresult result=new noteresult();
		result=nService.renote(userid);
		return result;
	}
}
