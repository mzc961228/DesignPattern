package hwService;

import java.util.List;

public interface BaseService <T>{
	//base增加
	public int create(T entity);

	//base修改
	public int update(Long id,T entity);

	//base删除
	public int delete(Object key);
	
	//base 查找
	public T selectByKey(Object key);
	
	//base按页查找
	public List<T> selectAll(Long pid, List<T> List);
}
