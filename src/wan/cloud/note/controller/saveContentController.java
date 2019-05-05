package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class saveContentController {

	@Resource
	private noteService nService;
	@RequestMapping("/savecontent.do")
	@ResponseBody
	public noteresult saveContent(String title,String body,String noteid){
		noteresult result=new noteresult();
		result=nService.saveContent(title, body, noteid);
		return result;
	}
	
	
}
