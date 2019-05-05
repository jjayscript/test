package wan.cloud.note.service;

import wan.cloud.note.entity.noteresult;

public interface userService {

	public noteresult checklogin(String name,String pwd) throws Exception;
	public noteresult regist(String name,String nickname,String pwd) throws Exception; 
	public noteresult find_username(String userid,String password)throws Exception;
	public noteresult modify_password(String userid,String password) throws Exception;
}