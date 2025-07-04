package mains;

import java.util.Scanner;

import containers.ArticuloContainer;
import containers.UsuarioContainer;
import utils.menuClientes;

public class MainClientes {

	public static void iniciar(UsuarioContainer containerUser, ArticuloContainer artContainer, Scanner sc){
		menuClientes menu = new menuClientes(containerUser, artContainer, sc);
		menu.mostrarMenu();
	}

}
