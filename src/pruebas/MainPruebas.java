package pruebas;
import models.Articulo;
import models.Empleado;
import models.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import containers.UsuarioContainer;
import mains.MainCliente;
import mains.MainEmpleado;
import containers.ArticuloContainer;

public class MainPruebas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UsuarioContainer containerUser = new UsuarioContainer();
		ArticuloContainer artContainer = new ArticuloContainer();
		Empleado empleado = new Empleado();
		
		boolean continuar = true;
		int opc ;
		
		System.out.println("Bienvenido al sistema de compras");
		while(continuar) {
			System.out.println("¿Sos cliente o empleado?");
			System.out.println("1. Menu Empleado");
			System.out.println("2. Menu Cliente");
			System.out.println("3. Salir");
			opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				MainEmpleado.iniciar(empleado, artContainer, sc);
				break;
			case 2:
				MainCliente.iniciar(containerUser, artContainer, sc);
				break;
			case 3:
				continuar = false;
				System.out.println("¡Gracias vuelva pronto!");
			default:
				System.out.println("¡Opcion invalida!");
				break;
			}
			
		}
		
		
		

	}

}
