package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class swapController {

	@Resource
	private noteService nService;
	@RequestMapping("/swap.do")
	@ResponseBody
	public noteresult swapNote(String bookid,String noteid){
		noteresult result=new noteresult();
		result=nService.swapBookID(bookid, noteid);
		return result;
	}
}
