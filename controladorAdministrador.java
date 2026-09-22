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

import cacharrito.modelo.Administrador;
import cacharrito.repositorio.administrador;

@RestController
@RequestMapping("/administradores/a/")

public class controladorAdministrador {

	@Autowired
	private administrador repoAdministrador;

	@GetMapping("/listarTodo/")
	public List<Administrador> mostrarTodos(){
		return repoAdministrador.findAll();
	}

	@PostMapping("/buscarId/")
	public Administrador buscarId(@RequestParam("id") Long id) {
		return repoAdministrador.findById(id).get();
	}

	@PostMapping("/buscarUsuario/")
	public Optional<Administrador> buscarUsuario(@RequestParam("usuario") String usuario) {
		return repoAdministrador.findByUsuario(usuario);
	}

	@PostMapping("/login/")
	public Optional<Administrador> login(@RequestParam("usuario") String usuario,
			@RequestParam("password") String password) {
		return repoAdministrador.login(usuario, password);
	}

	@PostMapping("/guardarAdministrador/")
	public ResponseEntity<Administrador> guardar(@RequestBody Administrador a) {

		repoAdministrador.save(a);
		return ResponseEntity.ok(a);
	}

}