package com.revature.alchemyapp.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.alchemyapp.data.ShelfRepository;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;

@SpringBootTest
public class ShelfServiceTest {
	@MockBean
	private ShelfRepository shelfRepo;
	@MockBean 
	private ShelfService shelfServ;
	
	@Test
	void testGetAllShelves() {
		Mockito.when(shelfRepo.findAll()).thenReturn(new ArrayList<Shelf>());
		assertNotNull(shelfServ.getAllShelves());
	}
	
	@Test 
	void testCreateShelf() {
		Shelf mockShelf = new Shelf();
		Mockito.when(shelfRepo.save(mockShelf)).thenReturn(mockShelf);
		assertNotNull(shelfServ.createShelf(mockShelf));
	}
	
	@Test
	void testGetShelf() {
		Shelf mockShelf = new Shelf();
		Mockito.when(shelfRepo.findById((long) 1)).thenReturn(Optional.of(mockShelf));
		assertNotNull(shelfServ.getShelf((long) 1));
	}
	
	@Test 
	void testGetShelfWrongId() {
		Mockito.when(shelfRepo.findById((long) 999)).thenReturn(Optional.empty());
		assertNull(shelfServ.getShelf((long) 999));
	}
	
	@Test
	void testUpdateShelf() {
		Shelf mockShelf = new Shelf();
		mockShelf.setId((long) 1);
		Category mockCategory = new Category();
		mockCategory.setId((long) 1);
		mockCategory.setCategoryName("reading");
		mockShelf.setCategory(mockCategory);
		mockShelf.setBookCover("asdf");
		Mockito.when(shelfRepo.findById((long) 1)).thenReturn(Optional.of(mockShelf));
		Mockito.when(shelfRepo.save(mockShelf)).thenReturn(mockShelf);
		Mockito.when(shelfRepo.findById((long) 1)).thenReturn(Optional.of(mockShelf));
		assertNotNull(shelfServ.updateShelf(mockShelf));
	}

}
