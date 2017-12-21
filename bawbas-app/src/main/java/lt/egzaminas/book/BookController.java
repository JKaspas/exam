package lt.egzaminas.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
	@Autowired
	private BookService service;

	@GetMapping
	private List<BookUI> getAllBooks() {
		return service.getAllBooks();
	}

	@GetMapping("/{name}")
	private BookUI getOneBookByName(@PathVariable("name") String name) {
		return service.getBook(name);
	}

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	private void newBook(@RequestBody BookUI book) {
		service.createNewBook(book);
	}

	@PutMapping("/{id}")
	private void editBook(@PathVariable("id") Long id, @RequestBody BookUI book) {
		service.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	private void deletBook(@PathVariable("id") Long id) {
		service.deleteBook(id);
	}
}
