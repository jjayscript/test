package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.noteService;

@Controller
@RequestMapping("/note")
public class queryCollectionController {

	@Resource
	private noteService nService;
	
	@RequestMapping("/querycollection.do")
	@ResponseBody
	public noteresult querycollections(String userid){
		noteresult result=new noteresult();
		result=nService.query_collection(userid);
		return result;
	}
	
}
