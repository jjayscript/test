package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class deleteNoteController {

	@Resource
	private noteService nService;
	@RequestMapping("/deletenote.do")
	@ResponseBody
	public noteresult deNote(String noteid){
		noteresult result=new noteresult();
		result=nService.delete_note(noteid);
		return result;
	}
	
}
