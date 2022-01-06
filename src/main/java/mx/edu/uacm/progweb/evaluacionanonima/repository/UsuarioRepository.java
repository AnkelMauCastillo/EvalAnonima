package mx.edu.uacm.progweb.evaluacionanonima.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.progweb.evaluacionanonima.dominio.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	

	@Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
	public Usuario getUsuariorBycorreo(@Param("correo") String correo);

}
