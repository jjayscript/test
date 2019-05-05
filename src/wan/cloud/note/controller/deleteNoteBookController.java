package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.notebookService;

@Controller
@RequestMapping("/note")
public class deleteNoteBookController {

	@Resource
	private notebookService nService;
	@RequestMapping("/deleteBook.do")
	@ResponseBody
	public noteresult delete_notebook(String notebookid){
		noteresult result=new noteresult();
		result=nService.delete_book(notebookid);
		return result;
	}
}
