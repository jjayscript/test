package wan.cloud.note.DAO;

import java.util.List;

import wan.cloud.note.entity.cn_notebook;

public interface notebookDAO {

	public List<cn_notebook> findnotebooks(String id);
	public void newnotebook(cn_notebook notebook);
	public void renameBook(cn_notebook notebook);
	public void deleteNoteBook(cn_notebook notebook);
}
