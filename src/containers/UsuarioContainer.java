package containers;

import models.Usuario;
import java.util.ArrayList;

public class UsuarioContainer {

	private ArrayList<Usuario> listaUsuarios;

	// ************* CONSTRUCTOR DE USUARIOCONTAINER *****************
	public UsuarioContainer() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	// **************** GETTERS ***************
	public ArrayList<Usuario> getTodos() {
		ArrayList<Usuario> copiaListUser = new ArrayList<Usuario>(this.listaUsuarios);
		return copiaListUser;
	}

	// ************ METODOS ***************
	public void agregarUsuario(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		this.listaUsuarios.remove(usuario);
	}

	public boolean isUsuarioExistente(Usuario usuario) {
		// Asumimos que no existe
		boolean existe = false;

		for (Usuario usuarioB : listaUsuarios) {
			if (usuarioB.equals(usuario)) {
			//Si encuentra uno igual, automaticamente existe y cortamos el bucle
				existe = true;
				break;
			}
		}

		//Retornamos el resultado
		return existe;
	}

	public Usuario getUser(String userBuscado) {
		Usuario usuarioBuscado = null;

		for (Usuario usuario : this.listaUsuarios) {
			if (usuario.getNombreUser().equals(userBuscado)) {
				usuarioBuscado = usuario;
				break;
			}
		}
		return usuarioBuscado;
	}

	public Usuario getFirstUser() {
		return this.listaUsuarios.get(0);
	}

	/*
	 * TODO Es necesario crear un metodo para eliminar un usuario de la lista?
	 */
}
