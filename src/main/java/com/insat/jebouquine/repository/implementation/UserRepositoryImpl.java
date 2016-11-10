package com.insat.jebouquine.repository.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.repository.facade.GenericRepository;
import com.insat.jebouquine.repository.facade.IUserRepository;

@Repository("UserRepository")
public class UserRepositoryImpl extends GenericRepository<String, User> implements IUserRepository{

	@Override
	public void saveClient(User client) {	
		persist(client);
	}

	@Override
	public User authentificate(String email, String password) {
		Query query = getSession().createQuery("select u from User u where u.email = :email and u.passwd=:passwd");
		query.setString("email", email);
		query.setString("passwd", password);
		return (User)query.uniqueResult();
	}

	@Override
	public User findById(String id) {
		return getByKey(id);
	}

	@Override
	public void deleteClient(String id) {
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setString("id", id);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAllClients() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

}
