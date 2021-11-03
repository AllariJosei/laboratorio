package Referencia;

import java.util.List;
import java.util.ArrayList;

public class ReferenciaMetodo {

	public static void main(String[] args) {
		/* Referencia a          Class::staticMethod         Math::abs           n -> Math.abs(n)
		 * static method 
		 */
		Trabajo trabajo = new Trabajo() {
			
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
				
			}
		};
		
		Trabajo tLambda = () -> User.referenciaAMetodoEstatico();
		
		Trabajo trabajoMR = User::referenciaAMetodoEstatico;
		trabajoMR.accion();
		
		/* Referencia a un 				instancia::metodoInstancia  s:toString  ()->"string".toString
		 * metodo de instancia
		 * de un objeto  particular
		 */
		User user = new User("Allari");
		Trabajo tLambda2 = () -> user.referenciaAMetedoParticular();
		Trabajo trabajoMR2 = user::referenciaAMetedoParticular;
		trabajoMR2.accion();
		
		/*Referencia a un metodo		Class::metodoInstancia		String::toString		s -> s.toString(
		 * de instancia de un 
		 * objeto arbitrario
		 * de un tipo particular
		 */
		TrabajoString trabajoString = (palabra) -> palabra.toUpperCase();
		TrabajoString trabajoStringRM = String::toUpperCase;
		System.out.println(trabajoStringRM.accion("allariminusculas"));
		
		List<User> users = new ArrayList<>();
		users.add(new User("Allari"));
		users.add(new User("Oli"));
		users.add(new User("Allarito"));
		users.add(new User("Olivita"));
		
//		users.forEach(nombre -> nombre.mostrarNombre()); //Foreach con lambda
		users.forEach(User::mostrarNombre);  //foreach con refrencia a metodo
		
		/*Referencia a un		Class::new		String::new		()->new String 
		 * constructor
		 */
		IUser user1 = new IUser() {
			
			@Override
			public User crear(String nombre) {				
				return new User(nombre);
			}
		};
		
		IUser userL = (nombre -> new User(nombre));
		
		IUser user3 = User::new;
	}

}
