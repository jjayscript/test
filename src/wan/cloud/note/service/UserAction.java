package wan.cloud.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wan.cloud.note.DAO.UserDao;
import wan.cloud.note.service.userService;
import wan.cloud.note.entity.User;
import wan.cloud.note.entity.noteresult;
import wan.cloud.note.util.noteUtil;
@Service
//@Transactional
public class UserAction implements userService{

	@Resource
	private UserDao userdao;
	@Override
	public noteresult checklogin(String name, String pwd) throws Exception {
		
		noteresult result=new noteresult();
		User user=new User();
		String password=null;
			password=noteUtil.MD(pwd);
		 user=userdao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		if(!user.getCn_user_password().equals(password)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}else {
			result.setStatus(0);
			result.setData(user.getCn_user_id());
			result.setMsg("登录成功");
			return result;
		}
		 
		
	}
	@Override
	
	public noteresult regist(String name, String nickname, String pwd) throws Exception {
		noteresult result=new noteresult();
		User user=new User();
		String id=null;
		String password=null;
		user=userdao.findByName(name);
		if(user!=null){
			result.setStatus(1);//用户名已存在
			result.setMsg("用户名已存在");
			return result;
		}else{
			id=noteUtil.createID();
			password=noteUtil.MD(pwd);
			user.setCn_user_id(id);
			user.setCn_user_name(name);
			user.setCn_user_password(password);
			user.setCn_user_desc(nickname);
			userdao.save(user);
			result.setStatus(0);//注册成功
			return result;
		}
		
	}
	@Override
	public noteresult find_username(String userid,String password) throws Exception {
		noteresult result=new noteresult();
		String pwd=null;
		pwd=noteUtil.MD(password);
		User user=new User();
		user=userdao.findusername(userid);
		if(user.getCn_user_password().equals(pwd)){
		  result.setStatus(0);
		  result.setData(user);
		  return result;
		}else{
			result.setStatus(1);
			return result;
		}
		
	}
	@Override
	public noteresult modify_password(String userid, String password) throws Exception {
		noteresult result=new noteresult();
		User user=new User();
		String pwd=null;
		pwd=noteUtil.MD(password);
		user.setCn_user_id(userid);
		user.setCn_user_password(pwd);
		userdao.modifyPassword(user);
		result.setStatus(0);
		return result;
	}
	
	
	

}
