package wan.cloud.note.service;

import wan.cloud.note.entity.noteresult;

public interface shareService {

	public noteresult sharenote(String noteid);
	public noteresult query_share(String shareid);
}
