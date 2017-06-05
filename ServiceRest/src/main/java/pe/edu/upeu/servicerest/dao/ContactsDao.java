package pe.edu.upeu.servicerest.dao;

import java.util.List;

import pe.edu.upeu.servicerest.bean.Contacts;

public interface ContactsDao extends Dao<Contacts,Long>{

	List<Contacts> findContactsAll();

}
