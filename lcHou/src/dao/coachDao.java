package dao;

import java.util.List;

 
import entity.coach;

public interface coachDao {
	coach getCoach(int id);
	
	//��Ա��������
	
	List<coach> getCoachSelect();
	coach getCoachID(int id);


}
