package org.han.dao;

public interface GenericDAO<E, K , L> {
	public void create(E vo)throws Exception;
	
	public E read(K no)throws Exception;
	//��ȸ
	public void update(E vo)throws Exception;
	//����
	public void delete(K no)throws Exception;
	//����
	public L allread()throws Exception;
	
	//����¡
	
}
