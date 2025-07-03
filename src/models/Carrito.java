package models;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Articulo> articulos;
	
	public Carrito() {
		this.articulos = new ArrayList<Articulo>();
	}
	//
	// ******************* GETTERS ************************
	public ArrayList<Articulo> getArticulos(){
		return this.articulos;
	}
	
	public void agregarItem(Articulo articulo, int cant) {
		Articulo articuloCarrito = new Articulo(
				articulo.getID(), 
				articulo.getNombre(), 
				articulo.getPrecioNeto(), 
				cant);
			
		this.articulos.add(articuloCarrito);
			
		articulo.restarStock(cant);
	}
	
	public void eliminarItem(Articulo articulo, int cant) {
		articulos.
		this.articulos.remove(item);
		articulo.
	}
	
}
