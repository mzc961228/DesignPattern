package hwService;

import java.util.List;

public interface commenUserService  {
	public int register();
	public int login();
	public List<String> getUserInfo(Long pid, User user);
}

//管理员对用户的增删改查
public interface restrictedUserService extends BaseService{
	
}