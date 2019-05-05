package wan.cloud.note.DAO;



import java.util.List;

import wan.cloud.note.entity.User;
import wan.cloud.note.entity.cn_notebook;

public interface UserDao {
 
	public User findByName(String name);
	public void save(User user);
	public User findusername(String userid);
	public void modifyPassword(User user);
	public User finduser(String userid);
	public List<cn_notebook>findallbook();
}
