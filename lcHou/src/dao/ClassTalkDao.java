package dao;

import java.util.List;

import entity.ClassTalk;
import entity.Page1;

public interface ClassTalkDao {
int insert(ClassTalk ct);

List<ClassTalk> select(int id);

List<ClassTalk> getByName(String name);



List<ClassTalk> weekById(Page1 p,int count,int id);

int getAllCount(int count,int id);

int checkTalk(String name);

int update(ClassTalk ct);


List<ClassTalk> jree(String name);
}
