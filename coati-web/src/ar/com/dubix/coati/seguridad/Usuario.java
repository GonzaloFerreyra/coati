package ar.com.dubix.coati.seguridad;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Usuario implements Serializable {
	
	@Id
	private Long id;
	
	/**
	 * Username
	 */
	private String nombreUsuario;

	/**
	 * password
	 */
	private String password;

	/**
	 * Nombre y apellido;
	 */
	private String nombre;

	/**
	 * Dirección de mail
	 */
	private String email;

	/**
	 * Teléfono
	 */
	private String telefono;
	
	/**
	 * Id de sesión que se crea al iniciar la sesión y se destruye al 
	 * cerrarla. 
	 */
	private String sesionId;

	/**
	 * Constructor para objectify
	 */
	public Usuario() {
	}
	
	public Usuario(final String nombreUsuario, final String password,
			final String validacionPassword, final String nombre,
			final String email, final String telefono)
			throws UsuarioException {
		definirNombreUsuario(nombreUsuario);
		definirPassword(password, validacionPassword);
		definirNombre(nombre);
		definirEMail(email);
		this.telefono = telefono;
	}

	private void definirEMail(final String email)
			throws EmailInvalidoException {
		if ((email == null) || (email.isEmpty())) {
			throw new EmailInvalidoException();
		}
		this.email = email;
	}

	private void definirNombre(final String nombre)
			throws NombreNuloException {
		if ((nombre == null) || (nombre.isEmpty())) {
			throw new NombreNuloException();
		}
		this.nombre = nombre;
	}

	private void definirPassword(final String password, final String validacionPassword) 
			throws PasswordNuloException, ValidacionPasswordNuloException,
			PasswordNoValidadaException {
		if ((password == null) || (password.isEmpty())) {
			throw new PasswordNuloException();
		}
		if ((validacionPassword == null) || (validacionPassword.isEmpty())) {
			throw new ValidacionPasswordNuloException();
		}
		if (! password.equals(validacionPassword)) {
			throw new PasswordNoValidadaException();
		}
		try {
			this.password = SHAHelper.calcularSHA256(password);
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
	}

	private void definirNombreUsuario(final String nombreUsuario) 
			throws NombreUsuarioNuloException {
		if ((nombreUsuario == null) || (nombreUsuario.isEmpty())) {
			throw new NombreUsuarioNuloException();
		}
		this.nombreUsuario = nombreUsuario;
	}
}
