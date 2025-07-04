package containers;
import models.Usuario;
import java.util.ArrayList;

public class UsuarioContainer {

	private ArrayList<Usuario> listaUsuarios;

	// --------------- CONSTRUCTOR -----------------
	public UsuarioContainer() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	//--------------- GETTERS ---------------------
	public ArrayList<Usuario> getTodos() {
		ArrayList<Usuario> copiaListUser = new ArrayList<Usuario>(this.listaUsuarios);
		return copiaListUser;
	}
	
	public Usuario getUserByID(int documento) {
		// Parto de la premisa que no existe
		Usuario usuarioEncontrado = null;

		// Recorro la lista
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getID() == documento) {
				// Si encuentro un usuario con el mismo documento, lo asigno
				usuarioEncontrado = usuario;
				break;
			}
		}

		// Devuelvo el resultado de la busqueda
		return usuarioEncontrado;
	}
	
	//---------------- AGREGAR/ELIMINAR --------------------------
	public void agregarUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		this.listaUsuarios.remove(usuario);
	}

	// ----------------- LOGIN --------------------------
	/* Para utilizar este metodo, antes se debe comprobar la existencia
	 * del usuario mediante getUserByID();
	 */
	
	public boolean login(Usuario usuario, String password) {
		// Parto de la premisa de acceso denegado
		boolean acceso = false;
		
		// Si la clave ingresada es igual a la de usuario, damos acceso
		if(usuario.validarPassword(password)) {
			acceso = true;
		}
	
		return acceso;
		
	}
	
	// -------- ESTO CREO QUE YA NO NOS SIRVE ---------------
	public Usuario getFirstUser() {
		return this.listaUsuarios.get(0);
	}
	// -----------------------------------------------------
	
	
}









/******************  OBSOLETOS  *************************
 * 
 * --------------------------------------------------------------- *
 * public boolean isUsuarioExistente(Usuario usuario) { 
 * // Asumimos que no existe 
 * 
 * boolean existe = false;
 * 
 * for (Usuario usuarioB : listaUsuarios) { if (usuarioB.equals(usuario)) { 
 * //Si encuentra uno igual, automaticamente existe y cortamos el bucle 
 * existe = true; 
 * break; 
 * } 
 * }
 * 
 * //Retornamos el resultado 
 * return existe; }
 * 
 * --------------------------------------------------------------- *
 * 
 * public Usuario getUser(String userBuscado) {
		Usuario usuarioBuscado = null;

		for (Usuario usuario : this.listaUsuarios) {
			if (usuario.getNombreUser().equals(userBuscado)) {
				usuarioBuscado = usuario;
				break;
			}
		}
		return usuarioBuscado;
	}
 * --------------------------------------------------------------- *
 * 
 * 
 * 
 * 
 * 
 */