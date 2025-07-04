package mains;

import java.util.Scanner;

import containers.ArticuloContainer;
import containers.UsuarioContainer;
import utils.MenuCliente;

public class MainCliente {

	public static void iniciar(UsuarioContainer containerUser, ArticuloContainer artContainer, Scanner sc){
		MenuCliente menu = new MenuCliente(containerUser, artContainer, sc);
		menu.mostrarMenu();
	}

}
