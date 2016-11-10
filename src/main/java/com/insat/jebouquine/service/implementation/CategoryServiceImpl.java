package com.insat.jebouquine.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insat.jebouquine.repository.entities.Category;
import com.insat.jebouquine.repository.facade.ICategoryRepository;
import com.insat.jebouquine.service.facade.ICategoryService;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryRepository dao;
	@Override
	public Category findById(String name) {
		return dao.findById(name);
	}

	@Override
	public void saveCategory(Category category) {
		dao.saveCategory(category);
		
	}

	@Override
	public void deleteCategory(String name) {
		dao.deleteCategory(name);
	}

	@Override
	public List<Category> findAllCategories() {
		return dao.findAllCategories();
	}
	@Override
	public boolean isCategoryExist(Category category) {
		Category entity=findById(category.getName());
		if(entity==null)
			return false;
		return true;
	}
}
