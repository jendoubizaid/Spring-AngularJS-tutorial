package com.insat.jebouquine.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.repository.facade.IUserRepository;
import com.insat.jebouquine.service.facade.IUserService;

@Service("clientService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository clientDao;

	@Override
	public User saveClient(User client) {
		User pswdExist=clientDao.authentificate(client.getEmail(), client.getPasswd());
		if(pswdExist!=null){
			System.out.println("client exist");
			return null;
		}	
		clientDao.saveClient(client);
		return client;
	}

	@Override
	public User authentificate(String email, String password) {
		return clientDao.authentificate(email, password);
	}

	@Override
	public User findById(String id) {
		return clientDao.findById(id);
	}

	@Override
	public void deleteClient(String id) {
		clientDao.deleteClient(id);
	}

	@Override
	public List<User> findAllClients() {
		return clientDao.findAllClients();
	}
}
