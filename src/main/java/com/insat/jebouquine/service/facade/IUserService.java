package com.insat.jebouquine.service.facade;

import java.util.List;

import com.insat.jebouquine.repository.entities.User;

public interface IUserService {
public User saveClient(User client);
	
	public User authentificate(String email,String password);
	
	public User findById(String id);

	public void deleteClient(String id);

	public List<User> findAllClients();
}
