package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.shareService;

@Controller
@RequestMapping("/share")
public class shareNoteController {

	@Resource
	private shareService share;
	@RequestMapping("/shareNote.do")
	@ResponseBody
	public noteresult shareNote(String noteid){
		noteresult result=new noteresult();
		result=share.sharenote(noteid);
		return result;
	}
}
