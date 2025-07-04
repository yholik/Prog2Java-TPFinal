package utils;
import models.Empleado;
import java.util.Scanner;
import models.Articulo;
import containers.ArticuloContainer;


/*TODO
 * 1.Crear un metodo de confirmacion de respuesta SI o No 
 * que devuelva un booleano para evitar repetir codigo.
 * 
 * 2.Es necesario llamar a menu principal cuando se decida regresar, no se como
 * es el metodo o si ya existe.
 * 
 * 3.Envolver el menu en un bucle para despues de ejecutar una opcion, vuelva
 * a mostrar el menu hasta que se decida salir.
 * 
 * 4.Revisar la variable global "confirmado" en mostrarMenuEmpleado.
 * 
 */
public class MenuEmpleado {
	private Scanner sc;
	private ArticuloContainer artContainer;
	

	Empleado empleadoAutorizado;

	// ---------- MENU INICIO SESION -----------
	public void menuInicioSesionEmpleado() {
		System.out.println("Bienvenido a la gestion de articulos \n" + "Para operar es necesario que te identifiques");

		String userEmpleado;
		String passwordEmpleado;
		boolean confirmado = false;

		do {
			System.out.println("Ingresa tu nombre de usuario:");
			userEmpleado = sc.next();
			System.out.println("Ingresa el password:");
			passwordEmpleado = sc.next();

			if (userEmpleado.equals(empleadoAutorizado.getNombre())
					&& empleadoAutorizado.validarPassword(passwordEmpleado)) {
				System.out.println("Bienvenido al sistema " + empleadoAutorizado.getNombre());
				confirmado = true;
			} else {
				System.out.println("Credenciales ingresadas incorrectas");
				System.out.println("¿Volver al menu principal?");
				char respuesta = sc.next().toUpperCase().charAt(0);
				if (respuesta == 'S') {
					// PONER MENU PRINCIPAL
				}
			}
		} while (!confirmado);
	}

	// ------------ MENU GESTION DE ARTICULOS -------------

	public void mostrarMenuEmpleado() {
		System.out.println("Selecciona una opcion");
		System.out.println("1- Ver artículos \n" + 
						   "2- Agregar artículo \n" +
						   "3- Modificar artículo \n" +
						   "4- Eliminar artículo \n" +
						   "5- Volver al menu principal \n");
		int opc = sc.nextInt();

		// ----- ZONA DE VARIABLES PARA ESTE METODO -----
		boolean confirmado = false;
		char respuesta;
		int ID;
		String nombre;
		double precio;
		int stock;

		// -----------------------------------------------

		switch (opc) {
		case 1: // ----------- LISTAR ARTICULOS -----------
			System.out.println("--- LISTA DE ARTICULOS ---");
			if (artContainer.getFirstArt() != null) {
				for (Articulo art : artContainer.getListaArticulos()) {
					System.out.println(art + " \n");
				}
			} else {
				System.out.println("No hay articulos");
			}
			break;

		case 2: // ---------- AGREGAR ARTICULO ---------------
				// ------- Ingresa ID del articulo ----------
			do {
				System.out.print("Ingresa ID del articulo");
				ID = sc.nextInt();
				if (artContainer.getArticuloByID(ID) != null) {
					System.out.println("El ID ya esta en uso");
				} else {
					confirmado = true;
				}
			} while (!confirmado);

			// -------- Ingresa nombre del articulo -----------
			System.out.println("Ingresa el nombre del articulo");
			nombre = sc.next();

			// -------- Ingresa precio neto del articulo --------
			do {
				System.out.println("Ingresa el precio neto");
				precio = sc.nextDouble();
				if (precio == 0) {
					System.out.println("No esta permitido poner articulos" + " con precio 0");
				}
			} while (precio <= 0);

			// -------- Ingresa stock del articulo ---------
			do {
				System.out.println("Ingresa stock del articulo");
				stock = sc.nextInt();
				if (stock < 0) {
					System.out.println("No podes ingresar stock negativo");
				} else {
					Articulo articuloNuevo = new Articulo(ID, nombre, precio, stock);
					confirmado = true;
					artContainer.agregarArticulo(articuloNuevo);
				}
			} while (!confirmado);

			break;

		case 3: // ---------- MODIFICAR ARTICULO POR ID ---------
			// No se como simplificar esta logica

			System.out.println("Ingresa el ID del articulo");
			ID = sc.nextInt();
			
			if(artContainer.getArticuloByID(ID) != null) {
			Articulo articuloModificar = artContainer.getArticuloByID(ID);

			// ------------- NOMBRE ----------------
			System.out.println("¿Queres modificar el nombre?");
			respuesta = sc.next().toUpperCase().charAt(0);
			if (respuesta == 'S') {
				System.out.println("Ingresa el nuevo nombre");
				nombre = sc.next();
				articuloModificar.setNombre(nombre);
			}

			// ----------- PRECIO ----------------
			System.out.println("¿Queres modificar el precio?");
			respuesta = sc.next().toUpperCase().charAt(0);
			if (respuesta == 'S') {
				System.out.println("Ingresa el nuevo precio");
				precio = sc.nextDouble();
				articuloModificar.setPrecioNeto(precio);
			}

			// --------- STOCK -----------------
			System.out.println("¿Queres modificar el stock?");
			respuesta = sc.next().toUpperCase().charAt(0);
			if (respuesta == 'S') {
				System.out.println("Ingresa el nuevo stock");
				stock = sc.nextInt();
				articuloModificar.setStock(stock);
			}
			}else{
				System.out.println("--- Articulo no encontrado ---");
				//ACA DEBERIA VOLVER AL MENU
				
			}
			break;

		case 4: // --------- ELIMINAR ARTICULO ------------
			do {
				System.out.println("Ingresa el ID del articulo a eliminar");
				ID = sc.nextInt();
				if (artContainer.getArticuloByID(ID) != null) {
					Articulo artAEliminar = artContainer.getArticuloByID(ID);
					artContainer.eliminarArticulo(artAEliminar);
					confirmado = true;
				} else {
					System.out.println("No existe el articulo");
				}
			} while (!confirmado);
			break;
			
		case 5: 
			System.out.println("Hasta luego " + empleadoAutorizado.getNombre());
		break;
		
		default: 
			System.out.println("*- ERROR INESPERADO -* \n"+
						 	   "Contactar a soporte técnico");
		}

	}

}
