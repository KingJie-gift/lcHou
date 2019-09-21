package entity;

public class interview {

	private int id;
	private int mem;
	private int stuid;
	private int cid;
	private int jieshao;
	private int problem;
	private int sum;
	private int time;
	private String  evalute;
	private String date;
	private student stu;//学员对象
	private class1 class1;//班级对象
	private member member;
	
 
	public member getMember() {
		return member;
	}
	public void setMember(member member) {
		this.member = member;
	}
	public int getMem() {
		return mem;
	}
	public void setMem(int mem) {
		this.mem = mem;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public student getStu() {
		return stu;
	}
	public void setStu(student stu) {
		this.stu = stu;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getJieshao() {
		return jieshao;
	}
	public void setJieshao(int jieshao) {
		this.jieshao = jieshao;
	}
	public int getProblem() {
		return problem;
	}
	public void setProblem(int problem) {
		this.problem = problem;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getEvalute() {
		return evalute;
	}
	public void setEvalute(String evalute) {
		this.evalute = evalute;
	}
	 
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	 
	public class1 getClass1() {
		return class1;
	}
	public void setClass1(class1 class1) {
		this.class1 = class1;
	}
	
	
}
