package pe.edu.upeu.servicerest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.upeu.servicerest.bean.Contacts;
//import pe.edu.upeu.servicerest.dao.CampaignDao;
import pe.edu.upeu.servicerest.dao.ContactsDao;

@Controller
public class RestController {

	@Autowired
	@Qualifier("contactsDao")
	protected ContactsDao contactsDao;
	//@PathVariable String parametro
	
	@RequestMapping(value = "/servicerest/test", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String findtest() {		
		return "Hola mundo";
	}
	
	
	@RequestMapping(value = "/servicerest/contactsAll/{parametro}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Contacts> findContactsAll(@PathVariable String parametro) {		
//		List<Contacts> list = new ArrayList<Contacts>();
//		Contacts campaign = new Contacts();
//		campaign.setId(1L);
//		campaign.setAllName("Juan Perez");
//		campaign.setNumberPhone("789522");
//		list.add(campaign);

//		campaign = new Campaign();
//		campaign.setId(2L);
//		campaign.setCampaingName("Alumnos de Ingeniería de Ambiental");
//		list.add(campaign);
//
//		campaign = new Campaign();
//		campaign.setId(3L);
//		campaign.setCampaingName("Alumnos de Administración");
//		list.add(campaign);
//
//		campaign = new Campaign();
//		campaign.setId(4L);
//		campaign.setCampaingName("Alumnos de Contabilidad");
//		list.add(campaign);
//
//		campaign = new Campaign();
//		campaign.setId(5L);
//		campaign.setCampaingName("Alumnos de Ingeniería Civil");
//		list.add(campaign);
//
//		campaign = new Campaign();
//		campaign.setId(6L);
//		campaign.setCampaingName("Alumnos de Ingeniería de Industrias Alimentarias");
//		list.add(campaign);

//		return list;
		
		Contacts is = new Contacts();
		is.setAllName(parametro);
//		contactsDao.save(is);

		return contactsDao.findContactsAll();
	}

	@RequestMapping(value = "/servicerest/contactmessage/{parametro}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String findContacts(@PathVariable String parametro) {
		
		String string[]= parametro.split("-");
		
		System.out.println("parametro >>>>> "+parametro);
		
		Contacts con = new Contacts();
		con.setAllName(string[0]);
		con.setNumberPhone(string[1]);

		contactsDao.save(con);
		
		return "hola mundo cruelll "+parametro;
//		return "hola mundo cruelll ";
	}
	
	@RequestMapping(value = "/servicerest/contactbyid/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Contacts findContatsById(@PathVariable String id) {
		
		String string[]= id.split("-");
		
		Contacts conts = new Contacts();
		conts.setId(1L);
		conts.setAllName(string[0]);
		conts.setNumberPhone(string[1]);;
		return conts;
	}

	@RequestMapping(value = "/servicerest/contactsave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Contacts addCampaign(@RequestBody Contacts contacts) {
		// return countryService.addCountry(country);
		return null;
	}

	@RequestMapping(value = "/servicerest/contactupdate", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Contacts updateCountry(@RequestBody Contacts contacts) {
		// return countryService.updateCountry(country);
		return null;
	}

	@RequestMapping(value = "/contactndelete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		// countryService.deleteCountry(id);
	}
}
