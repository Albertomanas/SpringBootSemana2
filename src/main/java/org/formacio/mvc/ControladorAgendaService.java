package org.formacio.mvc;


import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 1r caso test,  controlador de AgendaService que procese la path "/nombre"
 */
@Controller
public class ControladorAgendaService {
	@Autowired
	private AgendaService agendaService;

	@RequestMapping(path = "/nombre", method = RequestMethod.GET)
	@ResponseBody
	public String nombreContactes() {
		Integer nombreContactes = agendaService.nombreContactes();
		return nombreContactes.toString();
	}
	
	/*
	 * 2d caso test, tiene que pasar el telefono del id pasado como parametro:
	 */
	
	@RequestMapping(path = "/telefon", method = RequestMethod.GET)
	@ResponseBody
	public String obtenerTelefono(@RequestParam String id) {
		return agendaService.recupera(id).getTelefon();
		/*
		 * @RequestParam sirve para extraer la id para el endpoint
		 * Permite obtener el telefono de la id X.
		 */
	}
	
	/*
	 * 3r caso test, contacte/id, corresponer id pasado como parametro {id}
	 * Solo tiene que aceptar JSON (MediaType.APPLICATION_JSON)
	 */
	
	@RequestMapping(path = "/contacte/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Persona obtenerContacto(@PathVariable String id){
		if(agendaService.recupera(id) == null) {
			throw new OperationException();
			/*
			 * Captación de excepciones en clase OperationException
			 */
		} else
			return agendaService.recupera(id);
	}
	
	/*
	 * Test_nou_contacte (/afegir) con post.
	 */
	
	@RequestMapping(path = "/afegir", method=RequestMethod.POST)
	@ResponseBody
	public String insertarContacto(@RequestParam String id, @RequestParam String nom, @RequestParam String telefon) {
		agendaService.inserta(id, nom, telefon);
		return "ok";
	}
	
}
