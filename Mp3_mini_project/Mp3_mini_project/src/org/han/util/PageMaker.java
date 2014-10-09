package org.han.util;

public class PageMaker {

	private int page; // 페이지
	private int cnt;  // 보여줄 총 게시물의 수 
	private int lineCount; // 페이지 수 (1~ x개까지 설정)
	private int perPage; // 페이지당 나올 게시물의 수
	private int first;
	private int last;
	
	public static int getNumber(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 1;
		}
	}
	
	public PageMaker(){
		this(1);
	}
	
	public PageMaker(int page){
		this(page, 0);
	}
	
	public PageMaker(String pageStr){
		this(getNumber(pageStr),0);
	}
	
	public PageMaker(int page, int cnt) {
		this(page, cnt, 10,10);
	}
	
	public PageMaker(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page;
		this.cnt = cnt;
		this.lineCount = lineCount;
		this.perPage = perPage;
		this.first = 1;
		this.last = 10;
	}
	

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	public int getRowNum(){
		
		return (  ( (int)(Math.ceil(page/(double)perPage)) ) * (perPage * lineCount))  +1;
	 	
	}
	
	public int getRnFirst(){
		
		return getRnLast() - perPage;
	}
	
	public int getRnLast(){
		
		return (page * perPage);
	}
	

	@Override
	public String toString() {
		return "PageMaker [page=" + page + ", cnt=" + cnt + ", lineCount="
				+ lineCount + ", perPage=" + perPage + "]";
	}
	
	public static void main(String[] args) {

		PageMaker maker = new PageMaker(12);
		System.out.println(maker.getRowNum());
	}
	
	
	
	
}






