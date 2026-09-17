package cacharrito.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cacharrito.modelo.Alquiler;
import cacharrito.repositorio.alquiler;

@RestController
@RequestMapping("/alquileres/al/")

public class controladorAlquiler {

	@Autowired
	private alquiler repoAlquiler;

	@GetMapping("/listarTodo/")
	public List<Alquiler> mostrarTodos(){
		return repoAlquiler.findAll();
	}

	@PostMapping("/buscarId/")
	public Alquiler buscarId(@RequestParam("id") Long id) {
		return repoAlquiler.findById(id).get();
	}

	@PostMapping("/buscarEstado/")
	public List<Alquiler> buscarEstado(@RequestParam("estado") String estado) {
		return repoAlquiler.findByEstado(estado);
	}

	@PostMapping("/buscarFechaInicio/")
	public List<Alquiler> buscarFechaInicio(@RequestParam("fechaInicio") LocalDate fechaInicio) {
		return repoAlquiler.findByFechaInicio(fechaInicio);
	}

	@PostMapping("/buscarUsuario/")
	public List<Alquiler> buscarUsuario(@RequestParam("idUsuario") Long idUsuario) {
		return repoAlquiler.findByUsuario_IdUsuario(idUsuario);
	}

	@PostMapping("/buscarVehiculo/")
	public List<Alquiler> buscarVehiculo(@RequestParam("idVehiculo") Long idVehiculo) {
		return repoAlquiler.findByVehiculo_IdVehiculo(idVehiculo);
	}

	@PostMapping("/buscarPlaca/")
	public List<Alquiler> buscarPlaca(@RequestParam("placa") String placa) {
		return repoAlquiler.findByVehiculo_Placa(placa);
	}

	@PostMapping("/guardarAlquiler/")
	public ResponseEntity<Alquiler> guardar(@RequestBody Alquiler a) {

		repoAlquiler.save(a);
		return ResponseEntity.ok(a);
	}

}