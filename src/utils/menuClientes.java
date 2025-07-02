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

	// Mostrar el menu con las opciones y las acciones que puede trabajar
	public void mostrarMenu() {
		boolean continuar = true;
		System.out.println("¡Bienvenido al menu de Clientes!");
		while (continuar) {
			System.out.println("Elija una opcion:");
			System.out.println("1. Ingresar con usuario y contraseña");
			System.out.println("2. Resgistrarse");
			System.out.println("3. Salir");
			int opc = sc.nextInt();
			switch (opc) {
			case 1:
				accesoCliente();
				break;
			case 2:
				agregarNuevoUsuario();
				break;
			case 3:
				continuar = false;
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida.");
				break;
			}

		}
	}

	// Metodo de acceso cliente
	public void accesoCliente() {
		System.out.println("Ingrese su nombre de usuario:");
		String nombreIngresado = sc.next();
		
		System.out.println("Ingrese su contraseña:");
		String contraseñaIngresada = sc.next();
		
		//faltaria agregar al lado de nombreIngresado contraseñaIngresada como parametro 
		Usuario cliente = containerUser.getUser(nombreIngresado);
		
		if (cliente != null) {
			System.out.println("Acceso permitido. Bienvenido " + cliente.getNombreUser()+"!");
			//aca se deberia incluir un acceso al menu de funciones del usuario logeado
			
		}else {
			System.out.println("Nombre de usuario o contraseña incorrectos.");
		}
		
	}

	// Metodo de agregar nuevo usuario, se verifica que la contraseña se ingrese
	// bien 2 veces
	public void agregarNuevoUsuario() {
		System.out.println("Ingrese el nombre del usuario nuevo");
		String nombreNuevo = sc.next();

		boolean listo = false;
		String nPassword = "";// La inicializo por las dudas
		String confirmacionPassword = "";

		do {
			// Ingresa por primera vez la contraseña
			System.out.println("Ingrese la contraseña:");
			nPassword = sc.next();

			// Reingreso para verificar
			System.out.println("Confirme la contraseña:");
			confirmacionPassword = sc.next();

			if (nPassword.isEmpty() || confirmacionPassword.isEmpty()) {
				System.out.println("La contraseña no puede estar vacia.");
			} else if (!nPassword.equals(confirmacionPassword)) {
				System.out.println("Las contraseñas no coinciden. Intente nuevamente.");
			} else {
				System.out.println("Las contraseñas coinciden.");
				listo = true;
			}
		} while (!listo);

		Usuario nUsuario = new Usuario(nombreNuevo, nPassword);
		containerUser.agregarUsuario(nUsuario);

		System.out.println("El usuario se registro correctamente.");
	}

}
