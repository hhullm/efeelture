package dao;

import java.util.List;

import entity.Status;

public interface StatusDao {
	
	void addStatus(Status status);
	
	void deleteStatus(Status status);
	
	void modifyStatus(Status status);
	
	List<Status> selectStatus(Status status);

}
