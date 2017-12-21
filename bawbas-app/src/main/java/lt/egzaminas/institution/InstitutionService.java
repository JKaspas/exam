package lt.egzaminas.institution;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.egzaminas.book.BookRepository;

@Service
@Transactional
public class InstitutionService {
	
	@Autowired
	private InstitutionRepository instRepo;
	@Autowired
	private BookRepository bookRepo;
	
	public void addInstitution(Institution inst) {
		instRepo.save(inst);
	}

	public List<Institution> getAllInstitutions() {
		return instRepo.findAll();
	}

	public Institution getInstitution(Long id) {
		return instRepo.findOne(id);
	}

	public void editInstitution(Long id, Institution inst) {
		inst.setId(id);
		instRepo.save(inst);
	}

	public void deleteInstitution(Long id) {
		instRepo.delete(id);
	}

	public void addBookToInstitution(Long instId, Long bookId) {
		Institution inst = instRepo.findOne(instId);
		inst.addBook(bookRepo.findOne(bookId));
	}
}
