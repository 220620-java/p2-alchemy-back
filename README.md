# p2-alchemy-back

## Relational Database 
![image](https://user-images.githubusercontent.com/59245649/182959130-577950c3-49c6-46aa-a540-60313bf2d95b.png)
```
create table person (
    id serial primary key,
    username varchar(30) unique not null,
    passwrd varchar(30) not null,
    first_name varchar(30) not null,
    last_name varchar(30) not null
);

create table shelf (
    id serial primary key,
    book_isbn varchar(13) not null,
    user_id integer references person(id),
    category_id integer references category(id)
);

create table category(
    id serial primary key,
    category_name varchar(30) unique not null
);
```

* Postgresql
* DBeaver
* Amazon RDB

## Java
### Models
* Category
* Shelf
* User
### Controllers
* @RequestMapping(path="/category") CategoryController
  * @GetMapping(path = "/all") ResponseEntity<List<Category>> getCategories()
* @RequestMapping(path="/shelf") ShelfController
  * @PostMapping ResponseEntity<Shelf> addShelf(@RequestBody ShelfRequest shelfRequest)
  * @GetMapping(path = "/all") ResponseEntity<List<Shelf>> getShelves(@PathVariable("id") Long shelfId)
* @RequestMapping(path = "/users") UserController
  * @GetMapping(path = "/{id}") ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
  * @PostMapping ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest)
  * @GetMapping(path = "/{username}/shelves") ResponseEntity<List<Shelf>> viewUserShelves(@PathVariable("username")String username)
  * @PutMapping(path = "/{userId}/addbook/{shelfId}") ResponseEntity<User> addShelf(@PathVariable("userId") Long userId, @PathVariable("shelfId") Long shelfId)
  * @PutMapping(path = "/{id}") ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("") Long id)
### Data
* JPA Repository
* Category Repository
	* Category findByCategoryName(String categoryName)
* Shelf Repository
	* List<Shelf> findByUserId(Long Id)
* User Repository
	* User findByUsername(String username)
### Services
* Category Service
  * public Category createCategory(Category category);
  * public Category getCategory(Long id);
  * public Category getCategoryByName(String name);
  * public List<Category> getAllCategories();
* Shelf Service
  * Shelf createShelf(Shelf shelf)
  * Shelf getShelf(Long id)
  * List<Shelf> getAllShelves()
  * Shelf updateShelf(Shelf shelf)
* User Service
  * User registerUser(User user)
  * User logIn(String username, String password)
  * User getUser(Long id)
  * User addBook(Shelf shelf, User user)
  * List<Category> getCategories()
  * User updateUser(User user)

  
