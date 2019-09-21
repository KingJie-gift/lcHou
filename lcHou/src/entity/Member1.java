package entity;

public class Member1 {
private	int id;
private	String name;
private	int classid;
private	int course;//0上午课，1下午课
private String 	motto;//格言
private	int tag;//0在部1退部
private String phone;


public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public int getCourse() {
	return course;
}
public void setCourse(int course) {
	this.course = course;
}
public String getMotto() {
	return motto;
}
public void setMotto(String motto) {
	this.motto = motto;
}
public int getTag() {
	return tag;
}
public void setTag(int tag) {
	this.tag = tag;
}
 

}
