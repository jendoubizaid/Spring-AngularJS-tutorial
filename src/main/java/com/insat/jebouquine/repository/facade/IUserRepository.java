package com.insat.jebouquine.repository.facade;

import java.util.List;

import com.insat.jebouquine.repository.entities.User;

public interface IUserRepository {
	public void saveClient(User client);
	
	public User authentificate(String email,String password);
	
	public User findById(String id);

	public void deleteClient(String id);

	public List<User> findAllClients();

}
