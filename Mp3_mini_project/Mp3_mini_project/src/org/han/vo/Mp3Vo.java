package org.han.vo;

import java.util.Date;

public class Mp3Vo {
	private Integer mno ; 
	private String title; 
	private String dsc; 
	private String cate; 
	private String userid; 
	private String fileName; 
	private Date regdate; 
	private Integer rcount; 
	private Integer vcount; 
	private String artist; 
	private String img; 
	private String albname;
			
	

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getfileName() {
		return fileName;
	}

	public void setfileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Integer getRcount() {
		return rcount;
	}

	public void setRcount(Integer rcount) {
		this.rcount = rcount;
	}

	public Integer getVcount() {
		return vcount;
	}

	public void setVcount(Integer vcount) {
		this.vcount = vcount;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAlbname() {
		return albname;
	}

	public void setAlbname(String albname) {
		this.albname = albname;
	}

	@Override
	public String toString() {
		return "Mp3Vo [mno=" + mno + ", title=" + title + ", dsc=" + dsc
				+ ", cate=" + cate + ", userid=" + userid + ", fileName="
				+ fileName + ", regdate=" + regdate + ", rcount=" + rcount
				+ ", vcount=" + vcount + ", artist=" + artist + ", img=" + img
				+ ", albname=" + albname + "]";
	}

	
	
}
