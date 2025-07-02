package models;

public class Usuario {

	private String nombreUser;
	private String passwordUser;
	private double saldo;
	private Carrito carrito;

	// *************** CONSTRUCTOR DE USUARIO *******************
	public Usuario(String nombre, String password) {
		this.nombreUser = nombre;
		this.passwordUser = password;
		this.saldo = 0; // SE DEBERA AGREGAR SALDO LUEGO DE CREAR USUARIO
		this.carrito = new Carrito();
	}

	// ************ TO STRING PARA MOSTRAR EL MODELO CORRECTAMENTE ********
	// Utilizado para mostrar listadoUsers
	@Override
	public String toString() {
		return "Usuario " + "Nombre: " + this.nombreUser + ", Saldo: $" + this.saldo;
	}

	// ******************* GETTERS ************************
	public String getNombreUser() {
		return this.nombreUser;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public boolean validarPassword(String claveIngresada) {
		boolean validez = false;
		if (this.passwordUser.equals(claveIngresada)) {
			validez = true;
		}
		return validez;
	}
	
	public void modificarClave(String nuevaClave, String claveAntigua) {
		if(this.validarPassword(claveAntigua)) {
			this.passwordUser = nuevaClave;
		}
	}
	
	//*************************************************************

	// ************ METODOS AGREGAR/RETIRAR SALDO ****************
	public void agregarSaldo(double importe) {
		this.saldo += importe;
	}

	public void retirarSaldo(double importe) {
		this.saldo -= importe;
	}
	// ************************************************************

	/*
	 * TODO REVISAR, SI EL USUARIO AL REGISTRAR COLOCA CLAVE, QUEREMOS QUE PUEDA
	 * MODIFICARLA DESPUES? public void setPasswordUser(String passwordUser) {
	 * this.passwordUser = passwordUser; }
	 */

	/*
	 * TODO REVISAR: SI EL USUARIO SE CREA CON NOMBRE, QUEREMOS QUE PUEDA MODIFICAR
	 * SU NOMBRE LUEGO? public void setNombreUser(String nombreUser) {
	 * this.nombreUser = nombreUser; }
	 */
}
