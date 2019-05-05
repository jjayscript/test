package wan.cloud.note.service;

import wan.cloud.note.entity.noteresult;

public interface noteService {

	public noteresult findnoteID(String id);
	public noteresult addnote(String userid,String bookid,String booktitle);
	public noteresult findnotebody(String noteid);
	public noteresult saveContent(String notetitle,String content,String noteid);
	public noteresult updateStatus(String noteid);
	public noteresult swapBookID(String bookid,String noteid);
	public noteresult renote(String userid);
	public noteresult replay(String notebookid,String noteid);
	public noteresult delete_note(String noteid);
	public noteresult serach_note(String noteTitle);
	public noteresult rollback_content(String noteid);
	public noteresult insert_share(String userid,String shareid);
	public noteresult query_collection(String userid);
	
}
