package containers;
import models.Articulo;
import java.util.ArrayList;

// Esta clase contendra la lista completa de articulos que existen
// como tal, solo podra agregar o eliminar articulos a la lista, ya que la clase ARTICULO
// sabe hacer las cosas.-

public class ArticuloContainer {

	// Nombro a lista de articulos de la tienda con -> listaProductosSuper
	private ArrayList<Articulo> listaProductosSuper;

	public ArticuloContainer() {
		this.listaProductosSuper = new ArrayList<Articulo>();
	}
	
	//------------- METODOS ------------------
	
	public void agregarArticulo(Articulo articulo) {
		this.listaProductosSuper.add(articulo);
	}
	
	public void eliminarArticulo(Articulo articulo) {
		this.listaProductosSuper.remove(articulo);	
		}
	
	//------ LISTAR LOS ARTICULOS EN SU TOTALIDAD ---------------
	public ArrayList<Articulo> getListaArticulos() {
		ArrayList<Articulo> copiaListArticulos = new ArrayList<Articulo>(this.listaProductosSuper);
		return copiaListArticulos;
	}
	
	// ------------ BUSCAR UN PRODUCTO SEGUN ID -----------------
	public Articulo getArticuloByID(int articuloIDBuscado) {
		Articulo articuloBuscado = null;
		
		for (Articulo articulo : this.listaProductosSuper) {
			
			//Aca no use equals ya que es un tipo primitivo lo que recibe este metodo
			if(articulo.getID() == articuloIDBuscado) {
				articuloBuscado = articulo;
				break;
			}
		}
		return articuloBuscado;
	}
	
	public boolean isListaVacia() {
		boolean resultado = true;
		if(this.getListaArticulos().size() > 0) {
			resultado = false;
		}
		return resultado;
	}
}
