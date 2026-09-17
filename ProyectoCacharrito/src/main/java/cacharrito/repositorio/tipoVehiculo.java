package cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cacharrito.modelo.TipoVehiculo;

@Repository
public interface tipoVehiculo extends JpaRepository<TipoVehiculo, Integer> {

	public List<TipoVehiculo> findByNombreTipo(String nombreTipo);

	@Query(value = "select * from tipo_vehiculo order by nombre_tipo asc", nativeQuery = true)
	public List<TipoVehiculo> ordenAlfabetico();

}