package wan.cloud.note.DAO;

import wan.cloud.note.entity.cn_share;

public interface shareDAO {

	public void shareNote(cn_share share);
	public cn_share queryShare(String shareid);
}
