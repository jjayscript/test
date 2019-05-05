package wan.cloud.note.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
@Transactional
/**
 * rollbackFor添加其它类型的异常，也会产生回滚
 * readonly＝true只读
 * 默认是runtimeException 产生回滚
 * 自定义异常 继承runtimeexception
 * @author wanwenju
 *
 */
public class noteAction implements noteService{
    @Resource
	private noteDAO note;

    @Resource
    private shareDAO share;
	@Override
	public noteresult findnoteID(String id) {
		noteresult result=new noteresult();
		List<cn_note>listnote=note.findnotename(id);
		result.setStatus(0);
		result.setData(listnote);
		return result;
	}//通过noteID查询笔记信息

	@Override
	/**
	 * 新建笔记
	 * 
	 */
	public noteresult addnote(String userid, String bookid, String booktitle) {
		noteresult result=new noteresult();
		cn_note newnote=new cn_note();
		String noteid=noteUtil.createID();
		newnote.setCn_user_id(userid);
		newnote.setCn_notebook_id(bookid);
		newnote.setCn_note_title(booktitle);
		newnote.setCn_note_body("");
		newnote.setCn_note_status_id("1");
		newnote.setCn_note_type_id("");
		newnote.setCn_note_id(noteid);
		Long time=System.currentTimeMillis();
		newnote.setCn_note_create_time(time);
		newnote.setCn_note_last_modify_time(time);
		result.setStatus(0);
		note.newnote(newnote);
		result.setData(noteid);
		return result;
	}

	@Override
	/**
	 * 通过noteID查找笔记内容
	 */
	public noteresult findnotebody(String noteid) {
		noteresult result=new noteresult();
		cn_note cNote=new cn_note();
		cNote=note.findContent(noteid);
		result.setStatus(0);
		result.setData(cNote);
		return result;
	}

	@Override
	/**
	 * 保存更改后的笔记内容
	 */
	public noteresult saveContent(String notetitle, String content, String noteid) {
		noteresult result=new noteresult();
		cn_note cnote=new cn_note();
		cnote.setCn_note_title(notetitle);
		cnote.setCn_note_body(content);
		cnote.setCn_note_id(noteid);
		cnote.setCn_note_last_modify_time(System.currentTimeMillis());
		result.setStatus(0);
		note.saveContent(cnote);
		return result;
		
	}

	@Override
	/**
	 * 更新状态，删除笔记至回收站，2表示删除至回收站
	 */
	public noteresult updateStatus(String noteid) {
		noteresult result=new noteresult();
		cn_note cNote=new cn_note();
		cNote.setCn_note_id(noteid);
		
		cNote.setCn_note_last_modify_time(System.currentTimeMillis());
		note.updateStatus(cNote);
		result.setStatus(0);
		return result;
	}

	@Override
	/**
	 * 将笔记移动至别的笔记本中
	 */
	public noteresult swapBookID(String bookid, String noteid) {
		noteresult result=new noteresult();
		cn_note cNote=new cn_note();
		cNote.setCn_notebook_id(bookid);
		cNote.setCn_note_id(noteid);
		cNote.setCn_note_last_modify_time(System.currentTimeMillis());
		note.swapBookID(cNote);
		result.setStatus(0);
		return result;
		
	}

	@Override
	/**
	 * 重命名笔记
	 */
	public noteresult renote(String userid) {
		noteresult result=new noteresult();
		List<cn_note>listnotename=note.renotename(userid);
		result.setStatus(0);
		result.setData(listnotename);
		return result;
	}

	@Override
	/**
	 * 将笔记恢复至笔记本中
	 */
	public noteresult replay(String notebookid, String noteid) {
		noteresult result=new noteresult();
		cn_note cNote=new cn_note();
		cNote.setCn_notebook_id(notebookid);
		cNote.setCn_note_id(noteid);
		cNote.setCn_note_last_modify_time(System.currentTimeMillis());
		note.rollback(cNote);
		result.setStatus(0);
		return result;
	}

	@Override
	/**
	 * 彻底删除笔记
	 */
	public noteresult delete_note(String noteid) {
		noteresult result=new noteresult();
		result.setStatus(0);
		note.deleteNote(noteid);
		return result;
	}

	@Override
	public noteresult serach_note(String noteTitle) {
		noteresult result=new noteresult();
		cn_share cShare=new cn_share();
		cShare.setCn_share_title(noteTitle);
		
		List<cn_share>listnote=note.searchTitle(cShare);
		result.setStatus(0);
		result.setData(listnote);
		return result;
	}

	@Override
	public noteresult rollback_content(String noteid) {
		noteresult result=new noteresult();
		cn_note cNote=new cn_note();
		cNote=note.rollbackContent(noteid);
		result.setStatus(0);
		result.setData(cNote);
		return result;
	}

	@Override
	public noteresult insert_share(String userid, String shareid) {
		noteresult result=new noteresult();
		cn_share cShare=new cn_share();
		cn_note cNote=new cn_note();
		cn_note cNote2=new cn_note();
		cShare=share.queryShare(shareid);
		String share_title=null;
		String share_body=null;
		//String note_id=null;
		share_title=cShare.getCn_share_title();
		share_body=cShare.getCn_share_body();
		//note_id=cShare.getCn_note_id();
		cNote2=note.findContent(shareid);
		if(cNote2==null){
		cNote.setCn_user_id(userid);
		cNote.setCn_note_id(shareid);
		cNote.setCn_note_body(share_body);
		cNote.setCn_note_title(share_title);
		cNote.setCn_notebook_id("");
		cNote.setCn_note_create_time(System.currentTimeMillis());
		cNote.setCn_note_status_id("3");
		cNote.setCn_note_type_id("");
		cNote.setCn_note_last_modify_time(System.currentTimeMillis());
		note.newnote(cNote);
		result.setStatus(0);
		result.setData(cShare);
		return result;
		}else{
			result.setStatus(1);
			return result;
		}
		
	}

	@Override
	public noteresult query_collection(String userid) {
		noteresult result=new noteresult();
		List<cn_note>listnote=new ArrayList<cn_note>();
		listnote=note.querysharecollection(userid);
		result.setStatus(0);
		result.setData(listnote);
		return result;
	}

	
	
}








