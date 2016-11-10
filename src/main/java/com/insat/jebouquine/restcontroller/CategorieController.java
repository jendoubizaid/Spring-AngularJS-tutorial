package com.insat.jebouquine.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insat.jebouquine.repository.entities.Category;
import com.insat.jebouquine.service.facade.ICategoryService;

@RestController
@RequestMapping("/rest")
public class CategorieController {

	@Autowired
	ICategoryService categoryService;

	@RequestMapping(value = "/category/", method = RequestMethod.GET)
	public List<Category> listAllCategories() {
		List<Category> categories = categoryService.findAllCategories();
		for (Category category : categories) {
			System.out.println(category.getName());
		}
		if (categories.isEmpty()) {
			return null;
		}
		System.out.println("sending categories");
		return categories;
	}

	// -------------------Retrieve Single
	// Category--------------------------------------------------------

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Category getCategory(@PathVariable("id") String id) {
		System.out.println("Fetching Category with id " + id);
		Category category = categoryService.findById(id);
		if (category == null) {
			System.out.println("Category with id " + id + " not found");
			return null;
		}
		return category;
	}

	// -------------------Create a
	// Category--------------------------------------------------------

	@RequestMapping(value = "/category/", method = RequestMethod.POST)
	public boolean createCategory(@RequestBody Category category) {
		System.out.println("Creating Book " + category.getName());
		if (categoryService.isCategoryExist(category)) {
			System.out.println("A Book with name " + category.getName() + " already exist");
			return false;
		}

		categoryService.saveCategory(category);
		return true;
	}

	// ------------------- Delete a Book
	// --------------------------------------------------------

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable("id") String id) {
		System.out.println("Fetching & Deleting Category with name " + id);

		Category category = categoryService.findById(id);
		if (category == null) {
			System.out.println("Unable to delete. Category with name " + id + " not found");
			return false;
		}

		categoryService.deleteCategory(id);
		return true;
	}
}
