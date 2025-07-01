package models;
import models.Articulo;
import java.util.ArrayList;

public class Usuario {

	private String nombreUser;
	private String passwordUser;
	private double saldo;
	private Carrito carrito;
	
	// ***************  CONSTRUCTOR DE USUARIO *******************
	public Usuario(String nombre, String password) {
		this.nombreUser = nombre;
		this.passwordUser = password;
		this.saldo = 0; //SE DEBERA AGREGAR SALDO LUEGO DE CREAR USUARIO
		this.carrito = new Carrito();
	}

	// ************ TO STRING PARA MOSTRAR EL MODELO CORRECTAMENTE ********
	// Utilizado para mostrar listadoUsers 
	
	@Override
	public String toString() {
		return "Usuario "
				+ "Nombre: " + this.nombreUser +
				", Saldo: $" + this.saldo;
	}
	
	// ******************* GETTERS ************************
	public String getNombreUser() {
		return this.nombreUser;
	}
	
	//TODO Hacer un metodo validar contraseña, getPassword es mala practica
	public String getPasswordUser() {
		return this.passwordUser;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public Carrito getCarrito() {
		return this.carrito;
	}

	// ************ METODOS AGREGAR/RETIRAR SALDO ****************
	public void agregarSaldo(double importe) {
		this.saldo += importe;
	}
	
	public void retirarSaldo(double importe) {
		this.saldo -= importe;
	}
	//
	// ***************** SETTERS *********************
	/*
	 * TODO REVISAR, SI EL USUARIO AL REGISTRAR COLOCA CLAVE, QUEREMOS QUE PUEDA MODIFICARLA
	 * DESPUES? 
	 * public void setPasswordUser(String passwordUser) { 
	 * this.passwordUser = passwordUser; 
	 * }
	 */

	/* ***************** A DEFINIR ****************
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

