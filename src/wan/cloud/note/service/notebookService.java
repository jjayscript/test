package wan.cloud.note.service;

import wan.cloud.note.entity.noteresult;

public interface notebookService {
	public noteresult findnotebooks(String id);
	public noteresult newnotebook(String bookname,String userid);
	public noteresult rename_book(String notebookid,String notebookname);
	public noteresult delete_book(String notebookid);


}
