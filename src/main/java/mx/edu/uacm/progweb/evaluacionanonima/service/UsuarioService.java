package mx.edu.uacm.progweb.evaluacionanonima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.edu.uacm.progweb.evaluacionanonima.dominio.Role;
import mx.edu.uacm.progweb.evaluacionanonima.dominio.Usuario;
import mx.edu.uacm.progweb.evaluacionanonima.repository.RoleRepository;
import mx.edu.uacm.progweb.evaluacionanonima.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Usuario> listAll (){
		return (List<Usuario>) repository.findAll();
	}
	
	public List<Role> listRoles(){
		return (List<Role>) roleRepository.findAll();
	}

	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		encodePassword(usuario);
		repository.save(usuario);
	}
	
	private void encodePassword(Usuario usuario) {
		
		String encodePassword = passwordEncoder.encode(usuario.getContrasenia());
		usuario.setContrasenia(encodePassword);
	}
	
	public boolean isEmailUnique(String email) {
		Usuario usuarioEmail = repository.getUsuariorBycorreo(email);
		return usuarioEmail == null;
	}
	
	
	

}
