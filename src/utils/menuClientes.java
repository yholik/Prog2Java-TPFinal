package utils;

import java.util.Scanner;

import models.Articulo;
import models.Usuario;
import java.util.ArrayList;
import containers.ArticuloContainer;
import containers.UsuarioContainer;

public class menuClientes {

	private Usuario user;
	private Articulo art;
	private Scanner sc;
	private UsuarioContainer containerUser;
	private ArticuloContainer artContainer;

	public menuClientes(UsuarioContainer containerUser, ArticuloContainer artContainer, Scanner sc) {
		this.containerUser = containerUser;
		this.artContainer = artContainer;
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

	// Menu para los clientes que ya estan registrados y logeados corectamente
	private void menuClientesLogeados(Usuario user) {
		boolean continuar = true;
		Usuario cliente = user;
		while (continuar) {
			System.out.println("---Bienvenido " + cliente.getNombreUser() + "---");
			System.out.println("¿Que desea hacer?");
			System.out.println("1. Agregar articulo al carrito");
			System.out.println("2. Saldo(Agregar o Retirar)");
			System.out.println("3. Ver carrito");
			System.out.println("4. Pagar");
		}

	}

	// ------------------------- METODOS PARA MENU
	// PRINCIPAL------------------------------
	// Metodo de acceso cliente
	public void accesoCliente() {
		// El ingreso es por DNI y Contrasenia
		System.out.println("Ingrese su DNI de usuario:");
		int dniIngresado = sc.nextInt();

		System.out.println("Ingrese su contraseña:");
		String contraseniaIngresada = sc.next();

		Usuario cliente = containerUser.getUserByID(dniIngresado);

		if (cliente != null && containerUser.login(cliente, contraseniaIngresada)) {
			System.out.println("Acceso permitido. Bienvenido " + cliente.getNombreUser() + "!");
			menuClientesLogeados(cliente);
		} else {
			System.out.println("DNI o contraseña incorrectos.");
		}

	}

	// Metodo de agregar nuevo usuario, se verifica que la contraseña se ingrese
	// bien 2 veces
	public void agregarNuevoUsuario() {
		// Ingresa el dni a registrar
		System.out.println("Ingrese el numero de DNI.");
		int dniIngresado = sc.nextInt();

		// Se busca para saber si ya existe un user con ese dni
		Usuario user = containerUser.getUserByID(dniIngresado);

		// Si el usuario devuelto es null se realiza el registro habitual
		String nPassword = "";// La inicializo por las dudas
		String confirmacionPassword = "";

		if (user == null) {
			System.out.println("Ingrese el nombre de usuario:");
			String nombreIngresado = sc.next();
			boolean contraseniaValida = false;
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
					// Creacion del objeto usuario y se agrega al container
					Usuario nUsuario = new Usuario(nombreIngresado, nPassword, dniIngresado);
					containerUser.agregarUsuario(nUsuario);
					contraseniaValida = true;
				}
			} while (!contraseniaValida);

		} else {
			System.out.println("Este DNI ya pertenece a un usuario.");

		}

		System.out.println("El usuario se registro correctamente.");
	}

	// ------------------------ METODOS PARA MENU
	// LOGEADO-------------------------------
	private void mostrarListaDeArticulos() {
		System.out.println("\\n--- LISTA DE ARTICULOS ---");
		for (Articulo art : artContainer.getListaArticulos()) {
			System.out.println(art);// Se mostraria con el toString
		}
	}

	private void agregarArticuloAlCarrito(Usuario user) {
		this.mostrarListaDeArticulos();
		Usuario cliente = user;

		System.out.println("Ingrese el ID del articulo:");
		int id = sc.nextInt();
		Articulo art = artContainer.getArticuloByID(id);

		// Validacion si se puede agregar el articulo
		if (art == null) {
			System.out.println("No existe el articulo");
			return;
		}
		if (art.getStock() <= 0) {
			System.out.println("No hay stock");
			return;
		}
		
		System.out.println("Stock Disponible:"+ art.getStock());
		System.out.println("¿Cuantos desea agregar?");
		int cant = sc.nextInt();
		
		// Validamos que haya stock
		
		if (cant <=0) {
			System.out.println("Error: debe comprar un cantidad mayor a cero.");
			return;
		}
		
		if(cant > art.getStock())

	}

}
