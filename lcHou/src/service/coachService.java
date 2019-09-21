package service;

import java.util.List;

 
import entity.coach;

public interface coachService {
	coach getCoach(int id);
	
	//教员基础操作
	
	List<coach> getCoachSelect();
	coach getCoachID(int id);


}
