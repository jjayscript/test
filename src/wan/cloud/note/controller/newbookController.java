package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.notebookService;
@Controller
@RequestMapping("/notebook")
public class newbookController {

	@Resource
	private notebookService nService;
	@RequestMapping("/addbook.do")
	@ResponseBody
	public noteresult addBook(String bookname,String userid){
		noteresult result=new noteresult();
		result=nService.newnotebook(bookname, userid);
		return result;
	}
	
}
