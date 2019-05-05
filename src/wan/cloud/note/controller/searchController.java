package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class searchController {

	@Resource
	private noteService nService;
	@RequestMapping("/search.do")
	@ResponseBody
	public noteresult search(String title){
		noteresult result=new noteresult();
		result=nService.serach_note(title);
		return result;
	}
}
