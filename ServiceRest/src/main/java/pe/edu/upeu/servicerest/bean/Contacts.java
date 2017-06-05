package pe.edu.upeu.servicerest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="contacts")
public class Contacts implements BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Long id;

    @Column(length =100)
    private String allName;

    @Column(length =200)
    private String numberPhone;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAllName() {
		return allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
