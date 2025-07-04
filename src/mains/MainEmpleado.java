package mains;

import models.Empleado;
import java.util.Scanner;
import containers.ArticuloContainer;
import utils.MenuEmpleado;

public class MainEmpleado {

	public static void iniciar(Empleado empleado, ArticuloContainer artContainer, Scanner sc) {
		MenuEmpleado menu = new MenuEmpleado(empleado, artContainer, sc);
		menu.menuInicioSesionEmpleado();
	}
}
