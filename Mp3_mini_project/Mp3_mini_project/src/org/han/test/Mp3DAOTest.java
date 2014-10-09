package org.han.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.han.dao.Mp3DAO;
import org.han.dao.Mp3DAOImpl;
import org.han.vo.Mp3Vo;
import org.junit.Before;
import org.junit.Test;

public class Mp3DAOTest {

	Mp3DAO dao;
	
	@Before
	public void setUp() throws Exception {
		
		dao = new Mp3DAOImpl();
		
	}

	  @Test
	   public void Mp3Insert() {
	      try {
	         Mp3Vo vo = new Mp3Vo();
	         
	         vo.setTitle("������");
	         vo.setDsc("�������� ��� ������������");
	         vo.setCate("���߰���");
	         vo.setUserid("han33");
	         //UserID(FK) �����ϴ� ������ �ϱ�!
	         vo.setfileName("������.mp3");
	         vo.setArtist("������");
	         vo.setImg("image");
	         vo.setAlbname("DongHyuk-1stTitle");

	         dao.create(vo);
	         
	         
	         
	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }

	   @Test
	   public void Mp3Select() {
	   
	      try {
	         Mp3Vo vo = new Mp3Vo();
	            vo = dao.read(5);         
	            System.out.println(vo);

	      } catch (Exception e) {
	         fail(e.getMessage());
	      }

	   }

	   @Test
	   public void Mp3Update() {
	      try {
	         Mp3Vo vo = new Mp3Vo();
	         vo.setTitle("�����Ͽ� ������");
	         vo.setDsc("������ ������ ���� ��~");
	         vo.setCate("���߰���");
	         vo.setUserid("han01");
	         vo.setfileName("�����Ͽ� ������.mp3");
	         vo.setRcount(0);
	         vo.setVcount(15);
	         vo.setImg("image");
	         vo.setAlbname("DongHyuk-2ndTitle");
	         vo.setMno(23);

	         dao.update(vo);
	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }

	   @Test
	   public void Mp3allSelect() {
	      try {
	         List<Mp3Vo> list = new ArrayList<Mp3Vo>();
	            list = dao.allread();
	            for (Mp3Vo Mp3Vo : list) {
	               System.out.println(Mp3Vo.toString());
	               
	            }

	      } catch (Exception e) {
	         fail(e.getMessage());
	      }
	   }
	   
	   @Test
	   public void Mp3Delete() {
	      try{      
	         dao.delete(23);

	      }catch(Exception e){
	      fail(e.getMessage());
	      }
	   }
}
