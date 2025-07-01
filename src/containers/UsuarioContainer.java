package containers;
import models.Usuario;
import java.util.ArrayList;

public class UsuarioContainer {
	
	private ArrayList<Usuario> listaUsuarios;
	
	// ************* CONSTRUCTOR DE USUARIOCONTAINER *****************
	public UsuarioContainer(){
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
	
	public Usuario getUser(String userBuscado) {
		Usuario usuarioBuscado = null;
		
		for(Usuario usuario : this.listaUsuarios) {
			if(usuario.getNombreUser().equals(userBuscado)) {
				usuarioBuscado = usuario;
				break;
			}
		}
		return usuarioBuscado;
	}
	
	public Usuario getFirstUser() {
		return this.listaUsuarios.get(0);
	}
	
	/* TODO 
	 * Es necesario crear un metodo para eliminar un usuario de la lista?
	 */
}
