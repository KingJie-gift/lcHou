package entity;

import java.util.List;

public class pag {

	private int index,count,totalPage,totalData;
	private List list;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		if (index<1) {
			this.index = 1;
		}else if (index>this.totalPage) {
			this.index = this.totalPage==0?1:this.totalPage;
		}else {
			this.index = index;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		this.totalPage=this.totalData%this.count==0?(this.totalData/this.count):(this.totalData/this.count+1);
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
