package org.han.dao;

import java.util.ArrayList;
import java.util.List;

import org.han.util.SqlAgent;
import org.han.vo.Mp3Vo;

public class Mp3DAOImpl implements Mp3DAO {

	enum SQL {
		// 모든 SQL문에 세미콜론은 없다	
		INSERT("INSERT into tbl_mp3(mno, title, dsc, cate, userid, fileName, artist, img, albname) values (seq_mp3.nextval, ?, ?, ?, ?, ?, ?, ?, ?)"),
		SELECT("select * from tbl_mp3 where mno = ?"), 
		UPDATE("update tbl_mp3"
                + " set title = ?, dsc = ?, cate = ?, userid = ?, fileName = ?, rcount = ?, vcount = ?,"
                + " artist = ?, img = ?, albname = ?"
                + " where mno = ?"),
		DELETE("delete tbl_mp3 where mno=? "),
		ALLSEL("select*from tbl_mp3 order by mno"),
		PAGEING("SELECT * from(select/*+index_desc(tbl_mp3 pk_mno)*/ rownum rn, mno,title,artist,img,filename,albname , regdate from tbl_mp3 where rownum<=? and mno>0)where rn>?");
		
		String value;

		SQL(String value) {
			this.value = value;
		}
	}

	@Override
	public void create(Mp3Vo vo) throws Exception {
	
		
		new SqlAgent() {
			
			@Override
			protected void doJob() throws Exception {
				
				pstmt = con.prepareStatement(SQL.INSERT.value);
	
				System.out.println(vo.toString());
				//title, dsc, cate, userid, fileName, artist, img, albname
				
				pstmt.setString(1,vo.getTitle());
				pstmt.setString(2,vo.getDsc());
				pstmt.setString(3,vo.getCate());
				pstmt.setString(4,vo.getUserid());
				pstmt.setString(5,vo.getfileName());
				pstmt.setString(6,vo.getArtist());
				pstmt.setString(7,vo.getImg());
				pstmt.setString(8,vo.getAlbname());
				
				 int resultCount = pstmt.executeUpdate();

		            if (resultCount < 1) {
		               throw new Exception("MP3_INSERT ERROR");
		            }

				
			}
		}.doExecute();

	}

	@Override
	public Mp3Vo read(Integer no) throws Exception {

		final Mp3Vo vo = new Mp3Vo();

		new SqlAgent() {
	
			
			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.SELECT.value);

				pstmt.setInt(1, no);

				rs = pstmt.executeQuery();
				rs.next();

				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setDsc(rs.getString(3));
				vo.setCate(rs.getString(4));
				vo.setUserid(rs.getString(5));
				vo.setfileName(rs.getString(6));
				vo.setRcount(rs.getInt(7));
				vo.setVcount(rs.getInt(8));
				vo.setArtist(rs.getString(9));
				vo.setImg(rs.getString(10));
				vo.setAlbname(rs.getString(11));
				
				   int resultCount = pstmt.executeUpdate();

		            if (resultCount < 1) {
		               throw new Exception("MP3_READ ERROR");
		            }

			}
		}.doExecute();

		return vo;
	}

	@Override
	public void update(Mp3Vo vo) throws Exception {
		 new SqlAgent() {
	         @Override
	         protected void doJob() throws Exception {
	            pstmt = con.prepareStatement(SQL.UPDATE.value);

	            pstmt.setString(1, vo.getTitle());
	            pstmt.setString(2, vo.getDsc());
	            pstmt.setString(3, vo.getCate());
	            pstmt.setString(4, vo.getUserid());
	            pstmt.setString(5, vo.getfileName());
	            pstmt.setInt(6, vo.getRcount());
	            pstmt.setInt(7, vo.getVcount());
	            pstmt.setString(8, vo.getArtist());
	            pstmt.setString(9, vo.getImg());
	            pstmt.setString(10, vo.getAlbname());
	            pstmt.setInt(11, vo.getMno());

//	            System.out.println(vo.toString());
	            int resultCount = pstmt.executeUpdate();

	            if (resultCount < 1) {
	               throw new Exception("MP3_UPDATE ERROR");
	            }
	         }
	      }.doExecute();


	}

	@Override
	public void delete(Integer no) throws Exception {
		
		 new SqlAgent(){
	         @Override
	         protected void doJob() throws Exception {
	            pstmt = con.prepareStatement(SQL.DELETE.value);
	            pstmt.setInt(1, no);
	            
	            int resultCount = pstmt.executeUpdate();
	            
	            if(resultCount < 1){
	               throw new Exception("MP3_DELETE ERROR");
	            }
	         }
	         
	      }.doExecute();

	}

	@Override
	public List<Mp3Vo> allread() throws Exception {

		final List<Mp3Vo> voList = new ArrayList<Mp3Vo>();
		int frownum = 10;
		int lrownum = 1;

		new SqlAgent() {

			@Override
			protected void doJob() throws Exception {
				pstmt = con.prepareStatement(SQL.PAGEING.value);
				
			
				pstmt.setInt(1,10);
				pstmt.setInt(2,1);
				
				rs = pstmt.executeQuery();
				rs.next();
				
				while (rs.next()) {
					Mp3Vo vo = new Mp3Vo();
					//mno,title,artist,img,filename,albname 
				
//					vo.setMno(rs.getInt(1));
//					vo.setTitle(rs.getString(2));
//					vo.setArtist(rs.getString(3));
//					vo.setImg(rs.getString(4));
//					vo.setfileName(rs.getString(5));
//					vo.setAlbname(rs.getString(6));
					
					
					vo.setMno(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setDsc(rs.getString(3));
					vo.setCate(rs.getString(4));
					vo.setUserid(rs.getString(5));
					vo.setfileName(rs.getString(6));
					vo.setRegdate(rs.getDate(7));
					vo.setRcount(rs.getInt(8));
					vo.setVcount(rs.getInt(9));
					vo.setArtist(rs.getString(10));
					vo.setImg(rs.getString(11));
					vo.setAlbname(rs.getString(12));
					
					voList.add(vo);
					

				}

			}
		}.doExecute();
		return voList;

	}
}