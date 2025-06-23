package models;

public class Articulo {

	private int ID;
	private String nombre;
	private double precioNeto;
	private int stock;

	// ******************** CONSTRUCTOR DE ARTICULO *************************
	public Articulo(int identificador, String name, double importe, int cantidad) {
		this.ID = identificador;
		this.nombre = name;
		this.precioNeto = importe;
		this.stock = cantidad;
	}
	
	// *************** TO STRING ******************
	// Para mostrar el modelo de articulo correctamente
	
	@Override
	public String toString() {
		return "Articulo [ID=" + ID +
				", nombre=" + nombre + 
				", precioNeto=" + precioNeto + 
				", stock=" + stock + "]";
	}
	
	// ******************* GETTERS *******************************
	public String getNombre() {
		return nombre;
	}


	public double getPrecioNeto() {
		return precioNeto;
	}

	public int getStock() {
		return stock;
	}
	
	public int getID() {
		return ID;
	}
	
	// **************** SETTERS *******************************
	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}

	//Con este setter el Empleado podra editar el stock
	public void setStock(int stock) {
		this.stock = stock;
	}

	// Con este setter se restara una cantidad de unidades
	// que el usuario "Cliente" agregue a su carrito.
	
	public void restarStock(int cant) {
		this.stock -= cant;
	}
}
