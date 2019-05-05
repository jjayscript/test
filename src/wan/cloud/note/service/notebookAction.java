package wan.cloud.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import wan.cloud.note.DAO.noteDAO;
import wan.cloud.note.DAO.notebookDAO;
import wan.cloud.note.entity.cn_note;
import wan.cloud.note.entity.cn_notebook;
import wan.cloud.note.entity.noteresult;
import wan.cloud.note.util.noteUtil;

@Service
//@Transactional
       /*(isolation=Isolation
        *     .READ_UNCOMMITTED  读未提交
              .READ_COMMITTED    读已提交
              .REPEATABLE_READ   可重复读
              .SERIALIZABLE      序列化
              .DEFAULT           根据数据库隔离级别
		)*/
public class notebookAction implements notebookService {

	@Resource
	private notebookDAO notebook;
	@Resource
	private noteDAO note;
	@Override
	public noteresult findnotebooks(String id) {
		cn_notebook notebooks=new cn_notebook();
		noteresult result=new noteresult();
		List<cn_notebook>listnotebook=notebook.findnotebooks(id);
		result.setStatus(0);
		result.setData(listnotebook);
		return result;
	}
	
	@Override
	public noteresult newnotebook(String bookname,String userid) {
		String notebook_id=noteUtil.createID();
		noteresult result=new noteresult();
		cn_notebook book=new cn_notebook();
		book.setCn_notebook_id(notebook_id);
		book.setCn_user_id(userid);
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_name(bookname);
		book.setCn_notebook_desc("");
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		book.setCn_notebook_createtime(timestamp);
		notebook.newnotebook(book);
		result.setStatus(0);		
		result.setData(notebook_id);
		return result;
		
	}

	@Override
	public noteresult rename_book(String notebookid, String notebookname) {
		noteresult result=new noteresult();
		cn_notebook cNotebook=new cn_notebook();
		cNotebook.setCn_notebook_id(notebookid);
		cNotebook.setCn_notebook_name(notebookname);
		notebook.renameBook(cNotebook);
		result.setStatus(0);
		return result;
	}

	@Override
	public noteresult delete_book(String notebookid) {
		noteresult result=new noteresult();
		cn_notebook cNotebook=new cn_notebook();
		cn_note cNote=new cn_note();
		cNote.setCn_notebook_id(notebookid);
		note.deleteNotebook(cNote);
		cNotebook.setCn_notebook_id(notebookid);
		notebook.deleteNoteBook(cNotebook);
		result.setStatus(0);
		return result;
	}

	
	
	
}
