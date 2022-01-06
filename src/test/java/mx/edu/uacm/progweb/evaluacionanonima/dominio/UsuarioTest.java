package mx.edu.uacm.progweb.evaluacionanonima.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import mx.edu.uacm.progweb.evaluacionanonima.repository.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioTest {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role roleAdmin = entityManager.find(Role.class, Long.valueOf(2));
		Usuario usuario = new Usuario("eduardo.castillo@uacm.edu.mx", "eduardo", "castillo", "zavala", "1234");
		usuario.addRole(roleAdmin);
		
		Usuario  savedusuario = repo.save(usuario);
		
		assertThat(savedusuario.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testAllListUsers() {
		Iterable<Usuario> listUsers = repo.findAll();
		
		listUsers.forEach(usuario -> System.out.println(usuario));
	}
	
	@Test
	public void testGetUserById() {
		Usuario usuario = repo.findById(Long.valueOf(1)).get();
		System.out.println(usuario);
		assertThat(usuario).isNotNull();
	}
	
	@Test
	public void tesUpdateDetails() {
		Usuario usuario = repo.findById(Long.valueOf(1)).get();
		usuario.setHabilitado(true);
		usuario.setNombre("Angel Mauricio");
		
		repo.save(usuario);
	}
	
	@Test
	public void testUpdateRoles() {
		Usuario usuario = repo.findById(Long.valueOf(2)).get();
		Role userRole = new Role(Long.valueOf(2));
		Role adminRole = new Role(Long.valueOf(1));
		
		usuario.getRoles().remove(userRole);
		usuario.addRole(adminRole);
		
		repo.save(usuario);
	}
	
	@Test
	public void testDeleteUser() {
		Long idUser = Long.valueOf(2);
		repo.deleteById(idUser);
		
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "eduardo@uacm.edu.mx";
		Usuario usuario = repo.getUsuariorBycorreo(email);
		assertThat(usuario).isNotNull();
	}
}
