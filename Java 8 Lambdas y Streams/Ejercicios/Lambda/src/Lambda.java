
public class Lambda implements PorDefecto{

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.runtime.version"));
//		() -> "mi nombre es";
		MiNombre miNombreAnonima = new MiNombre() {
			
			@Override
			public String miNombre() {
				// TODO Auto-generated method stub
				return "Allari Anonimo";
			}
		};
		
		System.out.println(miNombreAnonima.miNombre());
		
		MiNombre miNombreLambda = () -> "Allari Lambda";
		System.out.println(miNombreLambda.miNombre());
		
		Sumar suma = new Sumar() {
			
			@Override
			public int suma(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		};
		System.out.println(suma.suma(2, 3));
		
		Sumar sumaLambda = (a,b) -> a+b;
		System.out.println(sumaLambda.suma(3, 4));
		
		Sumar sumaLambda2 = (a,b) -> {
			a = b * b;
			a = a + b;
			System.out.println("Mensaje dentro de lambda");
			return a;
		};
		System.out.println(sumaLambda2.suma(2, 3));
		
		Lambda l = new Lambda();
		System.out.println(l.nombrePorDefecto("Allari"));
	}

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

}
