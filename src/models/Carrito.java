package models;

import java.util.ArrayList;

public class Carrito {
	private static final int PRECIO_LIMITE_DESCUENTO = 12000;
	private static final float PORCENTAJE_DESCUENTO = 0.15f;
	
	private ArrayList<Articulo> articulos;
	
	public Carrito() {
		this.articulos = new ArrayList<Articulo>();
	}
	//
	// ******************* GETTERS ************************
	public ArrayList<Articulo> getArticulos(){
		return this.articulos;
	}
	//
	//Total sin descuento
	public double getSubTotal() {
		double subTotal = 0;
		
		if(this.articulos!=null) {
			for(int i=0; i<this.articulos.size(); i++) {
				subTotal += this.articulos.get(i).getPrecioNeto();
			}
		}
		
		return subTotal;
	}
	//
	//Total sin descuento
	public double getTotal() {
		double total = this.getSubTotal();
		
		if(total>PRECIO_LIMITE_DESCUENTO) {
			total = total - (total * PORCENTAJE_DESCUENTO);
		}
		
		return total;
	}
	//
	// ******************* Metodos Funcionales ************************
	//
	//Agrega item al carrito y resta stock global
	public void agregarItem(Articulo articuloEnStock, int cant) {
		Articulo articuloExistenteCarrito = this.getArticuloById(articuloEnStock.getID());
		
		if(articuloExistenteCarrito == null) {
			Articulo nuevoArticuloCarrito = new Articulo(
					articuloEnStock.getID(), 
					articuloEnStock.getNombre(), 
					articuloEnStock.getPrecioNeto(), 
					cant);
				
			this.articulos.add(nuevoArticuloCarrito);
		}
		else {
			articuloExistenteCarrito.sumarStock(cant);
		}
			
		articuloEnStock.restarStock(cant);
	}
	//
	//Elimina la totalidad del item del carrito y aumenta stock global
	public void eliminarItemCompleto(Articulo articuloEnStockGlobal) {
		for (Articulo item : articulos) {
	        if (item.getID() == articuloEnStockGlobal.getID()) {
	        	
	        	articuloEnStockGlobal.sumarStock(item.getStock());
	        	
	            this.articulos.remove(item);
	            
	            break;
	        }
	    }
	}
	//
	//Resta cantidad determinada del item del carrito y aumenta stock global
	public void restarCantidadItem(Articulo articuloEnStockGlobal, int cantidad) {
		for (Articulo item : articulos) {
	        if (item.getID() == articuloEnStockGlobal.getID()) {
	        	
	        	articuloEnStockGlobal.sumarStock(cantidad);
	        	
	            item.restarStock(cantidad);;
	            
	            break;
	        }
	    }
	}
	//
	// ******************* Metodos Privados ************************
	private Articulo getArticuloById(int id) {
		if (this.articulos != null) {
	        for (Articulo articulo : this.articulos) {
	            if (articulo.getID() == id) {
	                return articulo;
	            }
	        }
	    }
	    return null;
	}
}
