package models;

public class Usuario {

	private int documentoID;
	private String nombreUser;
	private String passwordUser;
	private double saldo;
	private Carrito carrito;

	// *************** CONSTRUCTOR DE USUARIO *******************
	public Usuario(String nombre, String password, int documento) {
		this.nombreUser = nombre;
		this.passwordUser = password;
		this.documentoID = documento;
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
	
	public int getID() {
		return this.documentoID;
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
}
