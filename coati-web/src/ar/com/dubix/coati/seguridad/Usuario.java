package ar.com.dubix.coati.seguridad;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	
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
		if ((email == null) || (email.trim().isEmpty())) {
			throw new EmailInvalidoException();
		}
		this.email = email.trim();
	}

	private void definirNombre(final String nombre)
			throws NombreNuloException {
		if ((nombre == null) || (nombre.trim().isEmpty())) {
			throw new NombreNuloException();
		}
		this.nombre = nombre.trim();
	}

	private void definirPassword(final String password, final String validacionPassword) 
			throws PasswordNuloException, ValidacionPasswordNuloException,
			PasswordNoValidadaException, PasswordMuyCortaException {
		if ((password == null) || (password.trim().isEmpty())) {
			throw new PasswordNuloException();
		}
		if ((validacionPassword == null) || (validacionPassword.trim().isEmpty())) {
			throw new ValidacionPasswordNuloException();
		}
		if (! password.trim().equals(validacionPassword.trim())) {
			throw new PasswordNoValidadaException();
		}
		if (! (password.trim().length() > 6)) {
			throw new PasswordMuyCortaException();
		}
		try {
			this.password = SHAHelper.calcularSHA256(password.trim());
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
	}

	private void definirNombreUsuario(final String nombreUsuario) 
			throws NombreUsuarioNuloException {
		if ((nombreUsuario == null) || (nombreUsuario.trim().isEmpty())) {
			throw new NombreUsuarioNuloException();
		}
		this.nombreUsuario = nombreUsuario.trim();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getSesionId() {
		return sesionId;
	}

	public boolean validarPassword(final String password) {
		try {
			String hashPassword = SHAHelper.calcularSHA256(password);
			return this.password.equals(hashPassword);
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
			return false;
		}
	}
}

