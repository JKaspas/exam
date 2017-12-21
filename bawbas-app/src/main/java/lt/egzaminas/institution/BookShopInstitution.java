package lt.egzaminas.institution;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "shop")
public class BookShopInstitution extends Institution {

	private boolean isForAdult; // for adult or child

	public boolean isForAdult() {
		return isForAdult;
	}

	public void setForAdult(boolean isForAdult) {
		this.isForAdult = isForAdult;
	}
}
