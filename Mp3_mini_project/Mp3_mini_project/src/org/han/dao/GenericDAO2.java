package org.han.dao;

import java.util.List;

import org.han.util.Criteria;

public interface GenericDAO2<E,K> {
	
	public void create(E vo)throws Exception;
	
	public E read(K key)throws Exception;
	
	public void update(E vo)throws Exception;
	
	public void delete(K key)throws Exception;
	
	public List<E> list(Criteria cri)throws Exception;
}
