package cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cacharrito.modelo.Vehiculo;
import cacharrito.repositorio.vehiculo;

@RestController
@RequestMapping("/vehiculos/v/")

public class controladorVehiculo {

	@Autowired
	private vehiculo repoVehiculo;

	@GetMapping("/listarTodo/")
	public List<Vehiculo> mostrarTodos(){
		return repoVehiculo.findAll();
	}

	@PostMapping("/buscarId/")
	public Vehiculo buscarId(@RequestParam("id") Long id) {
		return repoVehiculo.findById(id).get();
	}

	@PostMapping("/buscarPlaca/")
	public Optional<Vehiculo> buscarPlaca(@RequestParam("placa") String placa) {
		return repoVehiculo.findByPlaca(placa);
	}

	@PostMapping("/buscarEstado/")
	public List<Vehiculo> buscarEstado(@RequestParam("estado") String estado) {
		return repoVehiculo.findByEstado(estado);
	}

	@PostMapping("/buscarColor/")
	public List<Vehiculo> buscarColor(@RequestParam("color") String color) {
		return repoVehiculo.findByColor(color);
	}

	@PostMapping("/buscarTipo/")
	public List<Vehiculo> buscarTipo(@RequestParam("nombreTipo") String nombreTipo) {
		return repoVehiculo.findByTipoVehiculo_NombreTipo(nombreTipo);
	}

	@PostMapping("/disponibles/")
	public List<Vehiculo> disponibles() {
		return repoVehiculo.disponibles();
	}

	@PostMapping("/guardarVehiculo/")
	public ResponseEntity<Vehiculo> guardar(@RequestBody Vehiculo v) {

		repoVehiculo.save(v);
		return ResponseEntity.ok(v);
	}

}