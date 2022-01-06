package mx.edu.uacm.progweb.evaluacionanonima.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.progweb.evaluacionanonima.dominio.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
