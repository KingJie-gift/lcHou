package service;

import java.util.List;

 
import entity.coach;

public interface coachService {
	coach getCoach(int id);
	
	//��Ա��������
	
	List<coach> getCoachSelect();
	coach getCoachID(int id);


}
