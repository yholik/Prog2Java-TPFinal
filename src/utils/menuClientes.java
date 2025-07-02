package utils;

import java.util.Scanner;
import models.Usuario;
import java.util.ArrayList;
import containers.UsuarioContainer;


public class menuClientes {

	private Usuario user;
	private Scanner sc;
	private UsuarioContainer containerUser;
	
	public menuClientes(UsuarioContainer containerUser, Scanner sc) {
		this.containerUser = containerUser;
		this.sc = sc;
	}
	
	
	//Mostrar el menu con las opciones y las acciones que puede trabajar
	public void mostrarMenu() {
		boolean continuar = true;
		System.out.println("¡Bienvenido al menu de Clientes!");
		while(continuar) {
			System.out.println("Elija una opcion:");
			System.out.println("1. Ingresar con usuario y cogit ntraseña");
			System.out.println("2. Resgistrarse");
			System.out.println("3. Salir");
			int opc = sc.nextInt();
			switch (opc) {
            case 1 : accesoCliente();
            case 2 : agregarNuevoUsuario(containerUser);
            case 3 : continuar = false; System.out.println("Saliendo...");
            default : System.out.println("Opción inválida.");
		}
		
		
	}	
}
	
	public void accesoCliente() {
		
	}
	
	public void agregarNuevoUsuario(UsuarioContainer containerUser) {		
		System.out.println("Ingrese el nombre del usuario nuevo");
		String nombreNuevo = sc.next();
		
		//Verificar si ese nombre existe
		Usuario usuarioBuscado = containerUser.getUser(nombreNuevo);
		//TODA LA VALIDACION ES INNECESARIA XQ PUEDEN REPETIRSE LOS USUARIOS
		if(usuarioBuscado != null) {
			System.out.println("El usuario ya existe!");
		}else {
			boolean listo = false;
			String nPassword = "";
			do {
				System.out.println("Ingrese la contraseña:");
				nPassword = sc.next();
				
				if(!nPassword.isEmpty()) {
					listo = true;
				}else {
					System.out.println("La contraseña no puede estar vaica.");
				}
			}while(!listo);
			
			Usuario nUsuario = new Usuario(nombreNuevo, nPassword);
			containerUser.agregarUsuario(nUsuario);
			
			System.out.println("El usuario se registro correctamente.");
		}
		
		
		
		
	}

}
