package com.platform.open_house.repositories;

import java.sql.SQLException;
import java.util.List;

import com.platform.open_house.models.Request;

public interface RequestRepository {
	Integer createRequest(Request request);
	Request getRequestById(Integer requestId) throws SQLException;
	
	List<Request> getAllRequest();
	List<Request> getAllRequestByUserId(Integer userId);
	List<Request> getAllRequestNotByUserId(Integer userId);
	
	Boolean updateRequest(Request request);
	Boolean deleteRequest(Integer requestId);

}
