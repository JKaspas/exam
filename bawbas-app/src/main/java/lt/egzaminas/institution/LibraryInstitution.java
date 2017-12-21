package lt.egzaminas.institution;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "library")
public class LibraryInstitution {

	private boolean isForAdult; //child or adult

	public boolean isForAdult() {
		return isForAdult;
	}

	public void setForAdult(boolean isForAdult) {
		this.isForAdult = isForAdult;
	}
	
}
