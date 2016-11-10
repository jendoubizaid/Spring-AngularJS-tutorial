package com.insat.jebouquine.repository.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.insat.jebouquine.repository.entities.Category;
import com.insat.jebouquine.repository.facade.GenericRepository;
import com.insat.jebouquine.repository.facade.ICategoryRepository;
@Repository("CategoryDao")
public class CategoryRepositoryImpl extends GenericRepository<String, Category> implements ICategoryRepository{

	@Override
	public Category findById(String name) {
		return getByKey(name);
	}

	@Override
	public void saveCategory(Category category) {
		persist(category);
	}

	@Override
	public void deleteCategory(String name) {
		Query query = getSession().createSQLQuery("delete from Category where name = :name");
		query.setString("name", name);
		query.executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategories() {
		Criteria criteria = createEntityCriteria();
		return (List<Category>) criteria.list();
	}

}
