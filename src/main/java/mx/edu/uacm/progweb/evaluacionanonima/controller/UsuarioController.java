package mx.edu.uacm.progweb.evaluacionanonima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.edu.uacm.progweb.evaluacionanonima.dominio.Role;
import mx.edu.uacm.progweb.evaluacionanonima.dominio.Usuario;
import mx.edu.uacm.progweb.evaluacionanonima.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public String listAll(Model model) {
		List<Usuario> listaDeUsuarios = service.listAll();
		model.addAttribute("listaDeUsuarios", listaDeUsuarios);
		return "usuarios";
	}
	
	
	
	@GetMapping("/usuarios/nuevo")
	public String newUser(Model model) {
		List<Role> listaDeRoles =  service.listRoles();
		Usuario usuario = new Usuario();
		usuario.setHabilitado(true);
		model.addAttribute("usuario", usuario); 
		model.addAttribute("listaDeRoles", listaDeRoles);
		return "registro";
	}
	
	@PostMapping("/usuarios/save")
	public String saveUser(Usuario usuario, RedirectAttributes redirectAttributes) {
		System.out.println(usuario);
		service.save(usuario);
		
		redirectAttributes.addFlashAttribute("mensaje", "El usuario se ha guardado satisfactoriamente");	
		return "redirect:/usuarios";
	}
	
	
}
