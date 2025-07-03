package mains;
import models.Articulo;
import models.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import containers.UsuarioContainer;
import containers.ArticuloContainer;

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
		ArticuloContainer containerArticulo = new ArticuloContainer();
		
		
		// ************ AÑADO EL ARTICULO A LA LISTA DEL CONTAINER ************
		containerArticulo.agregarArticulo(articulo1);
		
		
		//**************ZONA DE INGRESO****************
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
		System.out.println("Ingresa tu documento");
		int documento = sc.nextInt();
		
		// *************** VERIFICACION CLAVE ********************
		if(passUDos.equals(passU)) {
			// Cuando creo este nuevo objeto en este ciclo, no puedo utilizarlo afuera
			// TODO : Averiguar como solucionar esto
			Usuario usuario = new Usuario(nombreU, passU, documento);
			containerUser.agregarUsuario(usuario);
			System.out.println("Usuario añadido con exito");
			confirmado = true;
		}else {
			System.out.println("Hay un error de credenciales");
			System.out.println("Volve a intentarlo");
			confirmado = false;
		}
		
		}
		
		//TODO Sacar usuario harcodeado
		Usuario usuarioActual = containerUser.getFirstUser();
		
		
		// Al añadir el item al carrito del usuario, se baja el stock
		usuarioActual.getCarrito().agregarItem(articulo1
				, 2);		
		
		
		// *********** LISTANDO USUARIOS REGISTRADOS ****************
		ArrayList<Usuario> listadoUsers = containerUser.getTodos();
		System.out.println("Lista de usuarios registrados:");
		for(Usuario usuario : listadoUsers) {
			System.out.println(usuario);
		}
		
		//TODO Se debe implementar una clase para listar los articulos
		ArrayList<Articulo> carritoAux = usuarioActual.getCarrito().getArticulos();
		for (Articulo item : carritoAux) {
			System.out.println(item.toString());
		}

		
		
	}

}
