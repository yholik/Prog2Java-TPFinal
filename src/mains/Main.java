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
		
		Usuario usuarioActual = containerUser.getUser("Yamila");
		
		usuarioActual.agregarItem(articulo1, 2);

		
		ArrayList<Usuario> listadoUsers = containerUser.getTodos();
		System.out.println("Lista de usuarios registrados:");
		for(Usuario usuario : listadoUsers) {
			System.out.println(usuario);
		}
		
		System.out.println(usuarioActual.getCarrito());

		
	}

}
