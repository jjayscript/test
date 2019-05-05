package wan.cloud.note.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;
@Controller
@RequestMapping("/note")
public class rollbackContentController {

	@Resource
	private noteService nService;
	@RequestMapping("/rollContent.do")
	@ResponseBody
	public noteresult rollbackContent(String noteid){
		noteresult result=new noteresult();
		result=nService.rollback_content(noteid);
		
		return result;
	}
}
