package library.controller.action;
import library.service.*;
import library.model.UserBean;
import library.service.UserService;
import library.service.UserTO;

public class UserBD {
  
	static UserBean Verify(UserBean ub)  {
		UserTO ut=Bean2TO(ub);
	
	    return  TO2Bean( service.Verify(ut) );     
	
	}
	
	static boolean addUser(UserBean ub) {
		UserTO ut=Bean2TO(ub);
		return service.addUser(ut);
	}
	static boolean updateUser(UserBean ub,String current_password) {
		UserTO ut=Bean2TO(ub);
		return service.updateUser(ut,current_password);
	}
		
	static boolean forgot(UserBean ub)
	{
		UserTO ut=Bean2TO(ub);
		return service.forgot(ut);
	}
		private static UserBean TO2Bean(UserTO bkt) {
			UserBean user = new UserBean(bkt.getName(), bkt.getUsername(), 
					bkt.getPassword(), bkt.getContact(),bkt.getType(),bkt.getRole());
			return user;
		}

		private static UserTO Bean2TO(UserBean bk) {
			UserTO user = new UserTO(bk.getName(),bk.getUsername(),bk.getPassword(),bk.getContact(),bk.getType(),bk.getRole());
			return user;
		}	
		private static UserService service = UserService.getInstance();	
	}


