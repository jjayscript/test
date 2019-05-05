package wan.cloud.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wan.cloud.note.DAO.noteDAO;
import wan.cloud.note.DAO.shareDAO;
import wan.cloud.note.entity.cn_note;
import wan.cloud.note.entity.cn_share;
import wan.cloud.note.entity.noteresult;
import wan.cloud.note.util.noteUtil;

@Service
//@Transactional
public class shareAction implements shareService{

	@Resource
	private shareDAO share;
	@Resource
	private noteDAO note;

	@Override
	public noteresult sharenote(String noteid) {
		noteresult result=new noteresult();
		cn_share cShare=new cn_share();
		cn_note cNote=new cn_note();
	    cNote=note.findContent(noteid);
		cShare.setCn_note_id(noteid);
		cShare.setCn_share_body(cNote.getCn_note_body());
		cShare.setCn_share_id(noteUtil.createID());
		cShare.setCn_share_title(cNote.getCn_note_title());
		share.shareNote(cShare);
		result.setStatus(0);
		
		return result;
	}

	@Override
	public noteresult query_share(String shareid) {
		noteresult result=new noteresult();
		cn_share cShare=new cn_share();
		cShare=share.queryShare(shareid);
		result.setStatus(0);
		result.setData(cShare);
		return result;
	}
	
	
}
