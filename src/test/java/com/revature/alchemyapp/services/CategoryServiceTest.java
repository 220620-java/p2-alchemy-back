package com.revature.alchemyapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.models.Category;

@SpringBootTest
public class CategoryServiceTest {
	@MockBean
	private CategoryRepository categoryRepo;
	@MockBean
	private CategoryService categoryServ;
	
	@Test
	void testGetAllCategories() {
		Mockito.when(categoryRepo.findAll()).thenReturn(new ArrayList<Category>());
		assertNotNull(categoryServ.getAllCategories());
	}
	
	@Test
	void testGetCategory() {
		Category mockCategory = new Category();
		Mockito.when(categoryRepo.findById((long) 1)).thenReturn(Optional.of(mockCategory));
		assertNotNull(categoryServ.getCategory((long) 1));
	}
	
	@Test
	void testGetCategoryWrongId() {
		Mockito.when(categoryRepo.findById((long) 1)).thenReturn(Optional.empty());
		assertNull(categoryServ.getCategory((long) 1));
	}
	
	@Test
	void testGetCategoryByName() {
		Category mockCategory = new Category();
		Mockito.when(categoryRepo.findByCategoryName("reading")).thenReturn(mockCategory);
		assertNotNull(categoryServ.getCategoryByName("reading"));
	}
	
	@Test 
	void testGetCategoryByWrongName() {
		Mockito.when(categoryRepo.findByCategoryName("wrong name")).thenReturn(null);
		assertNull(categoryServ.getCategoryByName("wrong name"));
	}
	
	@Test 
	void testCreateCategory() {
		Category mockCategory = new Category();
		Mockito.when(categoryRepo.save(mockCategory)).thenReturn(mockCategory);
		assertNotNull(categoryServ.createCategory(mockCategory));
	}
}
