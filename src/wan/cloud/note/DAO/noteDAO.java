package wan.cloud.note.DAO;

import java.util.List;

import wan.cloud.note.entity.cn_note;
import wan.cloud.note.entity.cn_share;

public interface noteDAO {

	public List<cn_note>findnotename(String id);
	public void newnote(cn_note note);
	public cn_note findContent(String noteid);
	public void saveContent(cn_note note);
	public void updateStatus(cn_note note);
	public void swapBookID(cn_note note);
	public List<cn_note>renotename(String id);
	public void rollback(cn_note note);
	public void deleteNote(String noteid);
	public List<cn_share>searchTitle(cn_share share);
	public cn_note rollbackContent(String noteid);
	public void deleteNotebook(cn_note note);
	public List<cn_note> querysharecollection(String userid);
	
}
