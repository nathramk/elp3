package pe.edu.upeu.servicerest.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.edu.upeu.servicerest.bean.Contacts;

public class ContactsDaoImpl extends JpaDao<Contacts, Long> implements ContactsDao {
    
	public ContactsDaoImpl() {
		super(Contacts.class);
	}

	@Transactional(readOnly = true)
	public List<Contacts> findContactsAll() {
		return find(Contacts.class,"From contacts");
	}

}
