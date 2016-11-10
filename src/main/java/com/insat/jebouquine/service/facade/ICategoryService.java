package com.insat.jebouquine.service.facade;

import java.util.List;

import com.insat.jebouquine.repository.entities.Category;

public interface ICategoryService {
	
	Category findById(String name);

	void saveCategory(Category category);

	void deleteCategory(String name);

	List<Category> findAllCategories();

	boolean isCategoryExist(Category category);
}
