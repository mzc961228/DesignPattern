package hwService;

//普通用户使用
 interface  commenUserService {
	//获取权限
	public  int getAuthority(int auId);
	
}
 
 //管理员使用
interface restrictedAuthorityService extends BaseService{
	
}