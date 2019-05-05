package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class replayController {

	@Resource
	private noteService nService;
	@RequestMapping("/replay.do")
	@ResponseBody
	public noteresult replayback(String notebookid,String noteid){
		noteresult result=new noteresult();
		result=nService.replay(notebookid, noteid);
		return result;
	}
}
