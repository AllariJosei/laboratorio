package Referencia;

public class User {
	private String nombre;
	
	public User(String nombre) {
		this.nombre = nombre;
	}
	
	public static void referenciaAMetodoEstatico() {
		System.out.println("Probando referencia a metodo estatico");
	}
	
	public void referenciaAMetedoParticular() {
		System.out.println("Probando Referencia a Método de Objeto Particular");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}

}
