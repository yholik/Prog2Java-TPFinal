package utils;

import java.util.Scanner;

import models.Articulo;
import models.Carrito;
import models.Usuario;
import java.util.ArrayList;
import containers.ArticuloContainer;
import containers.UsuarioContainer;

public class MenuCliente {

	private Usuario user;
	private Articulo art;
	private Scanner sc;
	private UsuarioContainer containerUser;
	private ArticuloContainer artContainer;

	public MenuCliente(UsuarioContainer containerUser, ArticuloContainer artContainer, Scanner sc) {
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
			System.out.println("Valor de carrito actual: $" + cliente.getCarrito().getSubTotal());
			System.out.println("¿Que desea hacer?");
			System.out.println("1. Agregar articulo al carrito");
			System.out.println("2. Quitar articulo del carrito");
			System.out.println("3. Saldo(Agregar o Retirar)");
			System.out.println("4. Ver carrito");
			System.out.println("5. Pagar");
			System.out.println("6. Salir");
			int opc = sc.nextInt();
			switch (opc) {
			case 1:
				agregarArticuloAlCarrito(cliente);
				break;
			case 2:
				eliminarArticuloDelCarrito(cliente);
				break;
			case 3:
				manejoSaldo(cliente);
				break;
			case 4:
				verCarrito(cliente);
				break;
			case 5:
				pagar(cliente);
				break;
			case 6:
				continuar = false;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}

	}

	// ------------------------- METODOS PARA MENU
	// PRINCIPAL------------------------------
	// Metodo de acceso cliente
	private void accesoCliente() {
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
	private void agregarNuevoUsuario() {
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
					System.out.println("El usuario se registro correctamente.");
				}
			} while (!contraseniaValida);

		} else {
			System.out.println("Este DNI ya pertenece a un usuario.");

		}

	}

	// ------------------------ METODOS PARA MENU
	// LOGEADO-------------------------------
	private void mostrarListaDeArticulos() {
		System.out.println("--- LISTA DE ARTICULOS ---");

		if (!artContainer.isListaVacia()) {

			// Esta es la validacion. No FirstArt
			if (artContainer.getListaArticulos() != null) {

				for (Articulo art : artContainer.getListaArticulos()) {
					System.out.println(art + " \n");
				}
			} else {
				System.out.println("No hay articulos");
			}
		}
	}

	// Opcion 1
	private void agregarArticuloAlCarrito(Usuario user) {
		mostrarListaDeArticulos();
		Usuario cliente = user;

		System.out.println("Ingrese el ID del articulo:");
		int id = sc.nextInt();
		Articulo art = artContainer.getArticuloByID(id);

		// Validaciones si se puede agregar el articulo------------------------
		if (art == null) {
			System.out.println("No existe el articulo");
			return;
		}
		if (art.getStock() <= 0) {
			System.out.println("No hay stock");
			return;
		}
		// Hasta aca las validaciones
		// ------------------------------------------------

		System.out.println("Stock Disponible:" + art.getStock());
		System.out.println("¿Cuantos desea agregar?");
		int cant = sc.nextInt();

		// Validamos que haya stock

		if (cant <= 0) {
			System.out.println("Error: debe comprar un cantidad mayor a cero.");
			return;
		}

		if (cant > art.getStock()) {
			System.out.println("Error: no hay suficiente stock. Disponible: " + art.getStock());
			return;
		}

		// Por fin agregamos el articulo
		cliente.getCarrito().agregarItem(art, cant);
		System.out.println(cant + "u de " + art.getNombre() + " agregadas al carrito");

	}

	// Opcion 2
	private void eliminarArticuloDelCarrito(Usuario user) {
		int id = 0;
		int cantidad = 0;
		Carrito carrito = user.getCarrito();

		if (carrito == null || carrito.getArticulos().isEmpty()) {
			System.out.println("Actualmente no posee articulos en su carrito.");
			return;
		}

		for (Articulo articulo : carrito.getArticulos()) {
			System.out.println(articulo.toString());
		}

		//Aca deberiamos poner verCarrito
		System.out.println("Ingrese el ID del articulo que desea eliminar(0 para cancelar):");
		id = sc.nextInt();

		if (id == 0) {
			System.out.println("Accion cancelada.");
			return;
		}

		Articulo articuloEnStockGeneral = this.artContainer.getArticuloByID(id);

		if (articuloEnStockGeneral == null) {
			System.out.println("El ID ingresado no corresponde a un articulo valido.");
			return;
		}

		do {
			cantidad = sc.nextInt();
			if (cantidad < 0) {
				System.out.println("La cantidad no puede ser negativa.");
			}
		} while (cantidad < 0);

		if (carrito.eliminarItem(articuloEnStockGeneral, cantidad)) {
			System.out.println("Se elimino o medifico la cantidad de articulos en el carrito de manera exitosa.");
		} else {
			System.out.println("No fue posible eliminar o medificar la cantidad de articulos en el carrito.");
			System.out.println("Revisa los datos ingresados y vuelvalo a intentar.");
		}
	}

	// Opcion 3 Manejo de saldo, vuelve a ser un minimenu
	private void manejoSaldo(Usuario user) {
		Usuario cliente = user;
		boolean continuar = true;

		while (continuar) {
			System.out.println("Saldo actual: $" + cliente.getSaldo());
			System.out.println("1. Agregar Saldo");
			System.out.println("2. Retirar Saldo");
			System.out.println("3. Salir");
			int opc = sc.nextInt();
			double cash;
			switch (opc) {
			case 1:
				System.out.println("¿Cuanto quiere agregar?");
				cash = sc.nextDouble();
				if (cash > 0) {
					cliente.agregarSaldo(cash);
					System.out.println("¡Ingreso exitoso!");
				} else {
					System.out.println("Debe ingresar dinero en positivo.");
				}
				break;
			case 2:
				System.out.println("¿Cuanto desea retirar?");
				cash = sc.nextDouble();
				if (cash > 0) {
					cliente.retirarSaldo(cash);
					System.out.println("¡Retiro exitoso!");
				} else {
					System.out.println("Debe retirar dinero en positivo.");
				}
			case 3:
				continuar = false;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}

		}

	}

	// Opcion 3 ver carrito
	private void verCarrito(Usuario cliente) {
		Carrito carritoAct = cliente.getCarrito();
		if (carritoAct == null || carritoAct.getArticulos().isEmpty()) {
			System.out.println("Tu carrito actualmente esta vacio.");
			return;
		}
		System.out.println("--- MI CARRITO ---");
		System.out.println("Nombre   |   Cantidad");
		for (Articulo art : carritoAct.getArticulos()) {

			System.out.println(art.getNombre() + ": ");
		}

	}

	private void pagar(Usuario user) {
		Usuario cliente = user;
		double valorCarrito = cliente.getCarrito().getTotal();
		double saldoCliente = cliente.getSaldo();

		if (valorCarrito < saldoCliente) {
			cliente.retirarSaldo(valorCarrito);
			System.out.println("Compra exitosa!");
		} else {
			System.out.println("No tiene suficiente saldo para comprar los articulos del carrito.");
			System.out.println("Agregue saldo o quite articulos.");
		}

	}
}
