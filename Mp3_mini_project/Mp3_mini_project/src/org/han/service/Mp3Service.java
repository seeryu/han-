package org.han.service;

import java.util.List;

import org.han.dao.Mp3DAOImpl;
import org.han.vo.Mp3Vo;

public class Mp3Service {
	
	private Mp3DAOImpl dao;
	
	public void setDao(Mp3DAOImpl dao){
		this.dao=dao;
	}
	
	public List<Mp3Vo> getList()throws Exception{
	//��ü ����Ʈ ����, Select
		return dao.allread();
	}
	
	
	public void setList(Mp3Vo vo) throws Exception{
	//���� ���ε�, Insert
		
		dao.create(vo);
		
	}
	
	public void updateList() throws Exception{
	//���� ����, Update
		Mp3Vo vo = new Mp3Vo();
		dao.update(vo);
		
	}
	
	public void delList() throws Exception{
	//���� ����, Delete	
		Integer no = null;
		dao.delete(no);
	}

}
