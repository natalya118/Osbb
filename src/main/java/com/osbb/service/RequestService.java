package com.osbb.service;

import java.util.List;

import com.osbb.model.Request;

public interface RequestService {
	Request getRequestById(String id);
	
	void createRequest(Request request);
	
	void updateRequest(Request request);
	
	void deleteRequest(String id);
	
	void deleteRequestsByUserId(String userId);
	
	List<Request> getAllRequests();
	
	List<Request> getAllRequestsForOsbb(String osbbId);
	
	List<Request> getAllRequestsByUser(String userId);
}
