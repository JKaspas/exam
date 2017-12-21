package lt.egzaminas.institution;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import lt.egzaminas.book.Book;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(include = As.PROPERTY, property = "type", use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
@JsonSubTypes({ @JsonSubTypes.Type(value = ArchiveInstitution.class, name = "archive"),
		@JsonSubTypes.Type(value = BookRentInstitution.class, name = "rent"),
		@JsonSubTypes.Type(value = BookShopInstitution.class, name = "shop"),
		@JsonSubTypes.Type(value = BookShopInstitution.class, name = "library") })
public abstract class Institution {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String city;
	private String image;
	private boolean category; // government or private

	@ManyToMany
	@JoinTable(name = "institution_book", joinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Institution() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isCategory() {
		return category;
	}

	public void setCategory(boolean category) {
		this.category = category;
	}

}
