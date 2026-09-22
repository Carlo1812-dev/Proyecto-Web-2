package cacharrito.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cacharrito.modelo.TipoVehiculo;
import cacharrito.repositorio.tipoVehiculo;

@RestController
@RequestMapping("/tipovehiculo/t/")

public class controladorTipoVehiculo {

	@Autowired
	private tipoVehiculo repoTipoVehiculo;

	@GetMapping("/listarTodo/")
	public List<TipoVehiculo> mostrarTodos(){
		return repoTipoVehiculo.findAll();
	}

	@PostMapping("/buscarId/")
	public TipoVehiculo buscarId(@RequestParam("id") Integer id) {
		return repoTipoVehiculo.findById(id).get();
	}

	@PostMapping("/buscarNombre/")
	public List<TipoVehiculo> buscarNombre(@RequestParam("nombreTipo") String nombreTipo) {
		return repoTipoVehiculo.findByNombreTipo(nombreTipo);
	}

	@PostMapping("/ordenAlfabetico/")
	public List<TipoVehiculo> ordenAlfabetico() {
		return repoTipoVehiculo.ordenAlfabetico();
	}

	@PostMapping("/guardarTipoVehiculo/")
	public ResponseEntity<TipoVehiculo> guardar(@RequestBody TipoVehiculo t) {

		repoTipoVehiculo.save(t);
		return ResponseEntity.ok(t);
	}

}