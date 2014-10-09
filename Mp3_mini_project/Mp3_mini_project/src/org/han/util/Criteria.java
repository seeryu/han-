package org.han.util;

public interface Criteria {
	
	public int getPage();
	
	public int setPage(int page);
	
	public String getKeyword();
	
	public void setKeyword(String keyword);
	
	public String[] getTypes();
	
	public void setTypes(String[] types);
	
	public int getFirst();
	
	public int getLast();
	
	public boolean hasPrev();
	//전페이지 = 현재 번호 -1
	public boolean hasNext();
	//다음페이지 = 현재 번호 +1
}
