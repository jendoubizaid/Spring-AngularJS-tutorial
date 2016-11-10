package com.insat.jebouquine.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insat.jebouquine.repository.entities.Role;
import com.insat.jebouquine.repository.facade.IRoleRepository;
import com.insat.jebouquine.service.facade.IRoleService;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleRepository roleDao;

	@Override
	public void saveRole(Role role) {
		roleDao.saveRole(role);
		
	}
	

}
