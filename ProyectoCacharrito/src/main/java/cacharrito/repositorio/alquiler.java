package cacharrito.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cacharrito.modelo.Alquiler;

@Repository
public interface alquiler extends JpaRepository<Alquiler, Long> {

	public List<Alquiler> findByEstado(String estado);

	public List<Alquiler> findByFechaInicio(LocalDate fechaInicio);

	public List<Alquiler> findByUsuario_IdUsuario(Long idUsuario);

	public List<Alquiler> findByVehiculo_IdVehiculo(Long idVehiculo);

	public List<Alquiler> findByVehiculo_Placa(String placa);

	@Query(value = "select * from alquiler where id_usuario = ?1", nativeQuery = true)
	public List<Alquiler> porUsuario(Long idUsuario);

}