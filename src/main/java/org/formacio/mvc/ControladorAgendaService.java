package org.formacio.mvc;


import org.formacio.repositori.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 1r caso test,  controlador de AgendaService que procese la path "/nombre"
 */
@Controller
public class ControladorAgendaService {
	@Autowired
	private AgendaService agendaService;

	@RequestMapping(path = "/nombre")
	@ResponseBody
	public String nombreContactes() {
		Integer nombreContactes = agendaService.nombreContactes();
		return nombreContactes.toString();
	}
	
}
