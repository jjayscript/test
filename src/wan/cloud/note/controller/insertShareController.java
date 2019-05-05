package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class insertShareController {

	@Resource
	private noteService nService;
	
	@RequestMapping("/insertshare.do")
	@ResponseBody
	public noteresult insertshare(String userid,String shareid){
		noteresult result=new noteresult();
		result=nService.insert_share(userid, shareid);
		return result;
	}
}
