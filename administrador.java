package cacharrito.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cacharrito.modelo.Administrador;

@Repository
public interface administrador extends JpaRepository<Administrador, Long> {

	public Optional<Administrador> findByUsuario(String usuario);

	@Query(value = "select * from administrador where usuario = ?1 and password = ?2", nativeQuery = true)
	public Optional<Administrador> login(String usuario, String password);

}