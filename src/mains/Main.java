package mains;
import models.Articulo;
import models.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import containers.UsuarioContainer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/* En orden de la consigna es necesario crear al incio
		 * del programa el objeto Empleado, la idea es consultar
		 * que tipo de rol es el usuario que quiere interactuar.
		 * 
		 * Si es Empleado, derivamos a menu para empleado, pero antes
		 * debera introducir sus credenciales.
		 * 
		 * Si es un cliente, verificamos si esta en la lista de usuarios registrados
		 * y si no lo esta, damos un menu para registrarse o salir.
		 * El usuario cliente si o si tiene que registrarse para operar.
		 */
		
		//CREO UN ARTICULO PARA PROBAR
		
		Articulo articulo1 = new Articulo(1, "Detergente" , 150, 2);
		
		UsuarioContainer containerUser = new UsuarioContainer();
		
		System.out.println("Para operar tenes que estar logueado");
		System.out.println("Creemos tu usuario:");
		
		boolean confirmado = false;
		
		while(!confirmado) {
		System.out.println("Nombre");
		String nombreU = sc.next();
		System.out.println("Crea tu clave");
		String passU = sc.next();
		System.out.println("Volve a ingresar tu clave");
		String passUDos = sc.next();
		
		
		if(passUDos.equals(passU)) {
			// Cuando creo este nuevo objeto en este ciclo, no puedo utilizarlo afuera
			// TODO : Averiguar como solucionar esto
			Usuario usuario = new Usuario(nombreU, passU);
			containerUser.agregarUsuario(usuario);
			System.out.println("Usuario añadido con exito");
			confirmado = true;
		}else {
			System.out.println("Hay un error de credenciales");
			System.out.println("Volve a intentarlo");
			confirmado = false;
		}
		
		}
		
		
		// Pruebo pasando por parametro un nombre que SE que yo ingrese antes
		Usuario usuarioActual = containerUser.getUser("Yamila");
		
		// Al añadir el item al carrito del usuario, se baja el stock
		usuarioActual.agregarItem(articulo1, 2);

		
		ArrayList<Usuario> listadoUsers = containerUser.getTodos();
		System.out.println("Lista de usuarios registrados:");
		for(Usuario usuario : listadoUsers) {
			System.out.println(usuario);
		}
		
		// Cuando muestro el carrito, muestra el stock del articulo y no cuantos esta comprando
		System.out.println(usuarioActual.getCarrito());

		
	}

}
