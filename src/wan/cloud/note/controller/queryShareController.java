package wan.cloud.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wan.cloud.note.entity.noteresult;
import wan.cloud.note.service.shareService;

@Controller
@RequestMapping("/share")
public class queryShareController {

	@Resource
	private shareService service;
	@RequestMapping("/queryshare.do")
	@ResponseBody
	public noteresult queryshare(String shareid){
		noteresult result=new noteresult();
		result=service.query_share(shareid);
		return result;
	}
}
