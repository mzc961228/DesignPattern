package hwService;

import java.util.List;

public interface commenUserService  {
	public int register();
	public int login();
	public List<String> getUserInfo(Long pid, User user);
}

//����Ա���û�����ɾ�Ĳ�
public interface restrictedUserService extends BaseService{
	
}