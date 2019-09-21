package entity;

public class class1 {

	 
	private int classid;
	private String classname;
	private int typeid;
	private int count;
	private String motto;
	private int teaid;
	private int coachid;
	private coach coach;
	private teacher tea;
	private Ctype ctype;

	
	
	
	
	
	 
	
	public teacher getTea() {
		return tea;
	}
	public void setTea(teacher tea) {
		this.tea = tea;
	}
	public Ctype getCtype() {
		return ctype;
	}
	public void setCtype(Ctype ctype) {
		this.ctype = ctype;
	}
	 
	public coach getCoach() {
		return coach;
	}
	public void setCoach(coach coach) {
		this.coach = coach;
	}
	 
	 
	public int getTeaid() {
		return teaid;
	}
	public void setTeaid(int teaid) {
		this.teaid = teaid;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	
}
