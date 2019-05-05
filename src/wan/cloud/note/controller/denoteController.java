package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class denoteController {

	@Resource
	private noteService nService;
	@RequestMapping("/upstatus.do")
	@ResponseBody
	public noteresult updateStatus(String noteid){
		noteresult result=new noteresult();
		result=nService.updateStatus(noteid);
		return result;
	}
}
