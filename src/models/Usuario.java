package models;
import models.Articulo;
import java.util.ArrayList;

public class Usuario {

	private String nombreUser;
	private String passwordUser;
	private double saldo;
	private ArrayList<Articulo> carrito;

	// ***************  CONSTRUCTOR DE USUARIO *******************
	public Usuario(String nombre, String password) {
		this.nombreUser = nombre;
		this.passwordUser = password;
		this.saldo = 0; //SE DEBERA AGREGAR SALDO LUEGO DE CREAR USUARIO
		this.carrito = new ArrayList<Articulo>();
	}

	// ************ TO STRING PARA MOSTRAR EL MODELO CORRECTAMENTE ********
	// Utilizado para mostrar listadoUsers 
	
	@Override
	public String toString() {
		return "Usuario [nombreUser=" + nombreUser +
				", saldo=" + saldo
				+ ", carrito=" + carrito + "]";
	}

	
	// ******************* GETTERS ************************
	public String getNombreUser() {
		return nombreUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public double getSaldo() {
		return saldo;
	}

	public ArrayList<Articulo> getCarrito() {
		ArrayList<Articulo> copiaCarrito = new ArrayList<Articulo>(this.carrito);
		return copiaCarrito;
	}

	// ************ METODOS AGREGAR/RETIRAR SALDO ****************
	public void agregarSaldo(double importe) {
		this.saldo += importe;
	}
	
	public void retirarSaldo(double importe) {
		this.saldo -= importe;
	}
	
	public void agregarItem(Articulo item, int cant) {
		for(int i = 0; i < cant; i++) {
		carrito.add(item);
		}
		item.restarStock(cant);
	}
	
	public void eliminarItem(Articulo item) {
		carrito.remove(item);
	}
	
	
	// ***************** SETTERS *********************
	/*
	 * TODO REVISAR, SI EL USUARIO AL REGISTRAR COLOCA CLAVE, QUEREMOS QUE PUEDA MODIFICARLA
	 * DESPUES? 
	 * public void setPasswordUser(String passwordUser) { 
	 * this.passwordUser = passwordUser; 
	 * }
	 */

	/*
	 * AL CREAR EL USUARIO LE DAMOS UN IMPORTE INICIAL DE 0 EN CONSTRUCTOR 
	 * public void
	 * setSaldo(double saldo) { this.saldo = saldo; }
	 */


	/* TODO REVISAR: SI EL USUARIO SE CREA CON NOMBRE, QUEREMOS QUE PUEDA MODIFICAR SU NOMBRE LUEGO?
	 * public void setNombreUser(String nombreUser) { 
	 * this.nombreUser = nombreUser;
	 * }
	 */
}

