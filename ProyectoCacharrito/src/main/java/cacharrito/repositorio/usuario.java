package cacharrito.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cacharrito.modelo.Usuarios;

@Repository
public interface usuario extends JpaRepository<Usuarios, Long> {

	public List<Usuarios> findByNombres(String nombres);

	public List<Usuarios> findByApellidos(String apellidos);

	public Optional<Usuarios> findByIdentificacion(String identificacion);

	public Optional<Usuarios> findByCorreo(String correo);

	public List<Usuarios> findByTelefono(String telefono);

	public List<Usuarios> findByCategoriaLicencia(String categoriaLicencia);

	public List<Usuarios> findByVigenciaLicenciaAfter(LocalDate fecha);

	@Query(value = "select * from usuarios where vigencia_licencia < curdate()", nativeQuery = true)
	public List<Usuarios> licenciaVencida();

}