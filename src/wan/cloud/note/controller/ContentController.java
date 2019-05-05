package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class ContentController {

	@Resource
	private noteService nService;
	@RequestMapping("/content.do")
	@ResponseBody
	public noteresult findContent(String noteid){
		noteresult result=new noteresult();
		result=nService.findnotebody(noteid);
		return result;
	}
}
