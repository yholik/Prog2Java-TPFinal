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
				Articulo aux = this.articulos.get(i);
				subTotal += (aux.getPrecioNeto() * aux.getStock());
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
	public void agregarItem(Articulo articulEnStockGeneral, int cant) {
		Articulo articuloExistenteCarrito = this.getArticuloById(articulEnStockGeneral.getID());
		
		if(articuloExistenteCarrito == null) {
			Articulo nuevoArticuloCarrito = new Articulo(
					articulEnStockGeneral.getID(), 
					articulEnStockGeneral.getNombre(), 
					articulEnStockGeneral.getPrecioNeto(), 
					cant);
				
			this.articulos.add(nuevoArticuloCarrito);
		}
		else {
			articuloExistenteCarrito.sumarStock(cant);
		}
			
		articulEnStockGeneral.restarStock(cant);
	}

	//
	//Resta cantidad determinada del item del carrito y aumenta stock global. 
	//Si cantidad de articulo queda en 0 entonces se elimina
	public boolean eliminarItem(Articulo articuloEnStockGeneral, int cantidad) {
		int stockItem = 0;
		
		if(cantidad>=0) {
			for (int i = 0; i < articulos.size(); i++) {
		        Articulo item = articulos.get(i);
		        if (item.getID() == articuloEnStockGeneral.getID()) {
		            stockItem = item.getStock();

		            if (stockItem <= cantidad) {
		                cantidad = stockItem;
		                articulos.remove(i);
		            } else {
		                item.restarStock(cantidad);
		            }

		            articuloEnStockGeneral.sumarStock(cantidad);
		            
		            return true;
		        }
		    }
		}
		
	    return false;
	}
	
	public void vaciarCarrito() {
		this.articulos = new ArrayList<Articulo>(); 
	}
	
	@Override
	public String toString() {
	    String nuevoString = "";

	    if (this.articulos != null) {
	        for (int i = 0; i < this.articulos.size(); i++) {
	            nuevoString += this.articulos.get(i).toString() + "\n";
	        }
	    }

	    return nuevoString;
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
