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
	
	public void agregarItem(Articulo item, int cant) {
		Articulo itemCarrito = new Articulo(
				item.getID(), 
				item.getNombre(), 
				item.getPrecioNeto(), 
				cant);
			
		this.articulos.add(itemCarrito);
			
		item.restarStock(cant);
	}
	
	public void eliminarItem(Articulo item) {
		this.articulos.remove(item);
		}
	
	
}
