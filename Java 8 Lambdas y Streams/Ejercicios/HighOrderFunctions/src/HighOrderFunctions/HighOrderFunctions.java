package HighOrderFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HighOrderFunctions implements SumarInterfaz{

	public static void main(String[] args) {
		
		HighOrderFunctions hof = new HighOrderFunctions();
		//-----------------------Función------------------//
		System.out.println(hof.suma(2,3));
		//-----------------------Interfaz-----------------//
		System.out.println(hof.apply(2, 4));
		//-----------------------High Order Functions-----//
		//					Forma tradicional
		/*
		SumarInterfaz sumarInterfaz = new SumarInterfaz() {
			@Override
			public int apply(int a, int b) { 
				return a+b;
			}			
		};*/
		//					Forma con lambdas
		SumarInterfaz sumarInterfaz = (a,b)-> a+b;
		System.out.println(hof.sumarHighOrderFun(sumarInterfaz, 2, 5));
		
		//--------Interfaz Funcional Function<T,R>--------//
		/*
		 * T es igual a el parametro de entrada
		 * R es lo que devuelve la funcion
		 * 	interface Function <T t, R r>
		 * {
		 * 		R apply(T t)
		 * }
		 */
		Function<String,String> convertirAMayusculas = e->e.toUpperCase();
		hof.imprimirMayusculas(convertirAMayusculas,"allari");
		//--------Interfaz Funcional BiFunction<T,U,R>--------//
		// T = primer parametro de entrada
		// U = segundo parametro de entrada
		// R = el retorno de la funcion
		/*
		interface BiFunction<T,U,R>
		{
			R apply (T t, U u)
		}
		*/
		
		
		//--------Interfaz Funcional Predicate<T>--------//
		// T= Parametro de entrada
		// Retorna un boolean
		/*
		interface Predicate<T>
		{
			Boolean text (T t)
		}
		*/
		List<Integer> numeros = Arrays.asList(6,23,-5,4,68,-9,-67,46);
		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar;
		filtrar = (lista,predicado) -> lista.stream().filter(e->predicado.test(e)).collect(Collectors.toList());
		System.out.println(filtrar.apply(numeros, e->e>0));
		
		//--------Interfaz Funcional Predicate<T>--------//
		// T = Parametro
		// No regresa ningun resultado
		/*
		interface Consumer<T>
		{
			void accept (T t)
		}
		*/
		List<String> nombres = new ArrayList<String>();
		nombres.add("Allari");
		nombres.add("Josei");
		nombres.add("Oli");
		hof.filtrar(nombres, e->System.out.println(e),6);
				
		
		
	}
	
	public int suma(int a, int b) {
		return a+b;
	}

	@Override
	public int apply(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	public int sumarHighOrderFun(SumarInterfaz sumar, int a, int b) {
		return sumar.apply(a, b);
	}
	
	public void imprimirMayusculas(Function<String,String> function, String nombre) {
		System.out.println(function.apply(nombre));
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumer, int maximoCaracteres) {
		lista.stream().filter(logicaPredicado(maximoCaracteres)).forEach(consumer);
	}
	
	public Predicate<String> logicaPredicado(int maximoCaracteres){
		return e -> e.length()<maximoCaracteres;
	}

}
