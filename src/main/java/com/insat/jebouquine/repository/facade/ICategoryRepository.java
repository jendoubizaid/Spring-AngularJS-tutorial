package com.insat.jebouquine.repository.facade;

import java.util.List;

import com.insat.jebouquine.repository.entities.Category;

public interface ICategoryRepository {
	
	Category findById(String name);

	void saveCategory(Category category);

	void deleteCategory(String name);

	List<Category> findAllCategories();
}
