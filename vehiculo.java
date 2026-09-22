package cacharrito.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cacharrito.modelo.Vehiculo;

@Repository
public interface vehiculo extends JpaRepository<Vehiculo, Long> {

	public Optional<Vehiculo> findByPlaca(String placa);

	public List<Vehiculo> findByEstado(String estado);

	public List<Vehiculo> findByColor(String color);

	public List<Vehiculo> findByTipoVehiculo_NombreTipo(String nombreTipo);

	@Query(value = "select * from vehiculo where estado = 'disponible'", nativeQuery = true)
	public List<Vehiculo> disponibles();

}