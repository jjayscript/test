package wan.cloud.note.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.notebookService;
@Controller
@RequestMapping("/notebook")
public class notebookController {

	@Resource
	private notebookService notebook;
	
	@RequestMapping("/notebook.do")
	@ResponseBody
	public noteresult notebooks(String id){
		noteresult result=new noteresult();
		result=notebook.findnotebooks(id);
		return result;
	}
	
	
}
