package org.han.util;



public class SimpleCriteria implements Criteria{
	
	private int page;
	private String[] type;
	private String keyword;

	private static int makeNum(String pageStr) {
		// TODO Auto-generated method stub
		try{
			return Integer.parseInt(pageStr);
		}catch(Exception e){
			return 1;
		}
	}
	
	public SimpleCriteria(String pageStr, String[] type, String keyword) {
		this(makeNum(pageStr), type, keyword);
	}
	

	public SimpleCriteria(int page, String[] type, String keyword) {
		super();
		this.page = page;
		this.type = type;
		this.keyword = keyword;
	}

	@Override
	public int getPage() {
		// 삼항 연산자 ( if else 같다)
		return this.page == 0? 1: this.page;
		//리턴값이 0이면 1을 반환하고 아니면 page를 반환한다.
	}

	@Override
	public int setPage(int page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return this.keyword == null?"":this.keyword;
	}

	@Override
	public void setKeyword(String keyword) {
		// TODO Auto-generated method stub
		this.keyword = keyword;
	}

	@Override
	public String[] getTypes() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void setTypes(String[] types) {
		// TODO Auto-generated method stub
		this.type = types;
	}

	@Override
	public int getFirst() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasPrev() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}
