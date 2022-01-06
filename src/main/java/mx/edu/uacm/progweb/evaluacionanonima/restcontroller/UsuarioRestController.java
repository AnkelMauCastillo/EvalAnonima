package mx.edu.uacm.progweb.evaluacionanonima.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uacm.progweb.evaluacionanonima.service.UsuarioService;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping("/usuarios/validar_email")
	public String checkDuplicateEmail(@Param("correo") String correo) {
		return service.isEmailUnique(correo) ? "OK" : "Duplicated";
		
	}
	
}
