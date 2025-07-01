package models;

public class Empleado {
	private String nombre;
	private String passwordEmpleado;
	// **************** CONSTRUCTOR ************
	
	public Empleado () {
		//USUARIO POR DEFECTO QUE DEBERA CONOCER EL EMPLEADO PARA OPERAR EN EL SISTEMA
		this.nombre = "admin";
		
		//CLAVE POR DEFECTO QUE DEBERA CONOCER EL EMPLEADO PARA OPERAR EN SISTEMA
		this.passwordEmpleado = "admin123";
	}
	
	// *************** GETTERS *******************
	public String getNombre() {
		return this.nombre;
	}
	
	//TODO Hacer un metodo validar contraseña, getPassword es mala practica
	public String getPasswordEmpleado() {
		return this.passwordEmpleado;
	}
	
	
}
