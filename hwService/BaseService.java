package hwService;

import java.util.List;

public interface BaseService <T>{
	//base����
	public int create(T entity);

	//base�޸�
	public int update(Long id,T entity);

	//baseɾ��
	public int delete(Object key);
	
	//base ����
	public T selectByKey(Object key);
	
	//base��ҳ����
	public List<T> selectAll(Long pid, List<T> List);
}
