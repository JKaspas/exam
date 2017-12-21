package lt.egzaminas.institution;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InstitutionController {
	@Autowired
	private InstitutionService service;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	private @ResponseBody <T extends Institution>T insertInstitution(@RequestBody T inst) {
		service.addInstitution(inst);
	    return inst;
	}
	
	@PutMapping("/{id}")
	private @ResponseBody <T extends Institution>T updateInstitution(@PathVariable Long id, @RequestBody T inst) {
		service.editInstitution(id, inst);
	    return inst;
	}
	
	@GetMapping
	private List<Institution> getAllInstitutions(){
		return service.getAllInstitutions();
	}
	
	@GetMapping("/{id}")
	private Institution getInstitutionById(@PathVariable Long id) {
		return service.getInstitution(id);
	}
	
	@DeleteMapping("{id}")
	private void deleteInstitution(@PathVariable Long id) {
		service.deleteInstitution(id);
	}
	@PostMapping("/{inst_id}/book/{book_id}")
	private void addBookToInstitution(@PathVariable("inst_id") Long instId, @PathVariable("book_id") Long bookId) {
		service.addBookToInstitution(instId,bookId);
	}
}
