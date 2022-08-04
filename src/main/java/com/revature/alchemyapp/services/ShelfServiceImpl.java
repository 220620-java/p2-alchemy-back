package com.revature.alchemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.data.ShelfRepository;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

@Service
public class ShelfServiceImpl implements ShelfService{
	private ShelfRepository shelfRepo;
	
	public ShelfServiceImpl(ShelfRepository shelfRepo) {
		this.shelfRepo=shelfRepo;
	}

	@Override
	public Shelf createShelf(Shelf shelf) {
		shelf.setId((long) 0);
		shelf = shelfRepo.save(shelf);
		return shelf;
	}
	
	@Override
	public Shelf getShelf(Long id) {
		Optional<Shelf> shelfOpt = shelfRepo.findById(id);
		if (shelfOpt.isPresent()) {
			return shelfOpt.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Shelf> getAllShelves() {
		List<Shelf> shelves = shelfRepo.findAll();
		return shelves;
	}

	@Override
	public Shelf updateShelf(Shelf shelf) {
		if(shelfRepo.findById(shelf.getId()).isPresent()) {
			shelfRepo.save(shelf);
			
			Optional<Shelf> shelfOpt = shelfRepo.findById(shelf.getId());
			if (shelfOpt.isPresent()) {
				return shelfOpt.get();
			}
		}
		return null;
	}

}
