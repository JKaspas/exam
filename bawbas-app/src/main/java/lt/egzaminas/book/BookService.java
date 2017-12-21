package lt.egzaminas.book;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;

	public BookRepository getBookRepo() {
		return bookRepo;
	}

	public void setBookRepo(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<BookUI> getAllBooks() {
		List<Book> bookDB = bookRepo.findAll();
		List<BookUI> booksUI = bookDB.stream().map((book) -> {
			BookUI b = new BookUI();
			b.setAuthor(book.getAuthor());
			b.setName(book.getName());
			b.setImage(book.getImage());
			return b;
		}).collect(Collectors.toList());
		return booksUI;
	}

	public BookUI getBook(String name) {
		Book bookDB = bookRepo.findByName(name);
		BookUI bookUI = new BookUI();
		bookUI.setId(bookDB.getId());
		bookUI.setAuthor(bookDB.getAuthor());
		bookUI.setName(bookDB.getName());
		bookUI.setImage(bookDB.getImage());
		bookUI.setPrice(bookDB.getPrice());
		bookUI.setPageNumber(bookDB.getPageNumber());
		bookUI.setQuantity(bookDB.getQuantity());
		bookUI.setStatus(bookDB.getStatus());
		return bookUI;
	}

	public void createNewBook(BookUI bookUI) {
		Book bookDB = new Book();
		bookDB.setAuthor(bookUI.getAuthor());
		bookDB.setName(bookUI.getName());
		bookDB.setImage(bookUI.getImage());
		bookDB.setPrice(bookUI.getPrice());
		bookDB.setPageNumber(bookUI.getPageNumber());
		bookDB.setQuantity(bookUI.getQuantity());
		bookDB.setStatus(bookUI.getStatus());
		bookRepo.save(bookDB);
	}

	public void updateBook(Long id, BookUI bookUI) {
		Book bookDB = bookRepo.findOne(id);
		if (bookUI.getName() != null)
			bookDB.setName(bookUI.getName());
		if (bookUI.getAuthor() != null)
			bookDB.setAuthor(bookUI.getAuthor());
		if (bookUI.getImage() != null)
			bookDB.setImage(bookUI.getImage());
		if (bookUI.getPageNumber() > 0)
			bookDB.setPageNumber(bookUI.getPageNumber());
		if (bookUI.getStatus() != null)
			bookDB.setStatus(bookUI.getStatus());
		
		bookDB.setPrice(bookUI.getPrice());
		bookDB.setQuantity(bookUI.getQuantity());
		bookRepo.save(bookDB);
	}

	public void deleteBook(Long id) {
		Book bookDB = bookRepo.findOne(id);
		bookRepo.delete(bookDB);
	}
}
