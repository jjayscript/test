package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class noteController {

	@Resource
	private noteService nService;
	@RequestMapping("/note.do")
	@ResponseBody
	public noteresult findnote(String id){
		noteresult result=new noteresult();
		result=nService.findnoteID(id);
		return result;
	}
}
