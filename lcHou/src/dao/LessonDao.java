package dao;

import java.util.List;

import entity.lesson;

public interface LessonDao {
int insert(lesson l);
List<lesson> getlessList();
int checklesson(int classid,int none,String week);

List<lesson> getById(int id);

List<lesson> getbyName(int id);
}
