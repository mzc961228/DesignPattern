package hwController;

public interface EcreditsController {
	//ʵ�ֿ�Ҫ���ڵĻ����Ȼ���
	public int payEcredits(Long userId,User user) {
		//�ҵ������Ҫ���ڵĻ���
		Ecredit tempCredit =selectByKey(Object key);
		
		//�Ļ�����Ŀ���е�ʣ�����
		EcreditService.update(userid,tempCredit);
		
		//�Ļ������
		commenUserService.getUserInfo(userId,user);
	}
	
	public int getEcreditsBySign{
		//���û��ֹ���ӿ�+���ֽӿ�
	}
	
	public int getEcreditsByShopping{
		//���û��ֹ���ӿ�+���ֽӿ�
	}
}
