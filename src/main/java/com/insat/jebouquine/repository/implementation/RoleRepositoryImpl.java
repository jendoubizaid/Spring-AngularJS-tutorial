package com.insat.jebouquine.repository.implementation;

import org.springframework.stereotype.Repository;

import com.insat.jebouquine.repository.entities.Role;
import com.insat.jebouquine.repository.facade.GenericRepository;
import com.insat.jebouquine.repository.facade.IRoleRepository;

@Repository("roleRepository")
public class RoleRepositoryImpl extends GenericRepository<String, Role> implements IRoleRepository{
	@Override
	public void saveRole(Role role) {
		persist(role);	
	}
}
