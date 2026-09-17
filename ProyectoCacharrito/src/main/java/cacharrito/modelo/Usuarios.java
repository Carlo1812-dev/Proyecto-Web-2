package cacharrito.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "identificacion", length = 20, nullable = false, unique = true)
    private String identificacion;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "fecha_expedicion_licencia")
    private String fechaExpedicionLicencia;

    @Column(name = "categoria_licencia", length = 50)
    private String categoriaLicencia;

    @Column(name = "vigencia_licencia")
    private String vigenciaLicencia;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    public Usuarios() {
    }

    public Usuarios(String identificacion, String nombres, String apellidos,
            String fechaExpedicionLicencia, String categoriaLicencia,
            String vigenciaLicencia, String correo, String telefono,
            String password) {
    	this.identificacion = identificacion;
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.fechaExpedicionLicencia = fechaExpedicionLicencia;
	this.categoriaLicencia = categoriaLicencia;
	this.vigenciaLicencia = vigenciaLicencia;
	this.correo = correo;
	this.telefono = telefono;
	this.password = password;
	}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaExpedicionLicencia() {
        return fechaExpedicionLicencia;
    }

    public void setFechaExpedicionLicencia(String fechaExpedicionLicencia) {
        this.fechaExpedicionLicencia = fechaExpedicionLicencia;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    public String getVigenciaLicencia() {
        return vigenciaLicencia;
    }

    public void setVigenciaLicencia(String vigenciaLicencia) {
        this.vigenciaLicencia = vigenciaLicencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
