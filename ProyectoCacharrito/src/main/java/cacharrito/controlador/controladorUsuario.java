package cacharrito.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cacharrito.modelo.Usuarios;
import cacharrito.repositorio.usuario;

@RestController
@RequestMapping("/usuarios/u/")

public class controladorUsuario {

	@Autowired
	private usuario repoUsuario;

	@GetMapping("/listarTodo/")
	public List<Usuarios> mostrarTodos(){
		return repoUsuario.findAll();
	}

	@PostMapping("/buscarId/")
	public Usuarios buscarId(@RequestParam("id") Long id) {
		return repoUsuario.findById(id).get();
	}

	@PostMapping("/buscarCC/")
	public Optional<Usuarios> buscarCC(@RequestParam("identificacion") String identificacion) {
		return repoUsuario.findByIdentificacion(identificacion);
	}

	@PostMapping("/buscarNombre/")
	public List<Usuarios> buscarNombre(@RequestParam("nombres") String nombres) {
		return repoUsuario.findByNombres(nombres);
	}

	@PostMapping("/buscarApellido/")
	public List<Usuarios> buscarApellido(@RequestParam("apellidos") String apellidos) {
		return repoUsuario.findByApellidos(apellidos);
	}

	@PostMapping("/buscarCorreo/")
	public Optional<Usuarios> buscarCorreo(@RequestParam("correo") String correo) {
		return repoUsuario.findByCorreo(correo);
	}

	@PostMapping("/buscarCategoriaLicencia/")
	public List<Usuarios> buscarCategoriaLicencia(@RequestParam("categoria") String categoria) {
		return repoUsuario.findByCategoriaLicencia(categoria);
	}

	@PostMapping("/guardarUsuario/")
	public ResponseEntity<Usuarios> guardar(@RequestBody Usuarios u) {

		repoUsuario.save(u);
		return ResponseEntity.ok(u);
	}

}