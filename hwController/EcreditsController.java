package hwController;

public interface EcreditsController {
	//实现快要到期的积分先花掉
	public int payEcredits(Long userId,User user) {
		//找到最近快要过期的积分
		Ecredit tempCredit =selectByKey(Object key);
		
		//改积分条目项中的剩余积分
		EcreditService.update(userid,tempCredit);
		
		//改积分余额
		commenUserService.getUserInfo(userId,user);
	}
	
	public int getEcreditsBySign{
		//调用积分规则接口+积分接口
	}
	
	public int getEcreditsByShopping{
		//调用积分规则接口+积分接口
	}
}
