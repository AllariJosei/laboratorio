package StreamPrueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrueba {
	
	private static List<User> listUser;

	public static void main(String[] args) {
		setUpUser();
		Stream stream = Stream.of(listUser); //Para instanciar Stream
		listUser.stream();  //Igual sirve para instanciar Stream
		
		listUser.stream().forEach(e->e.setNombre(e.getNombre() + " Apellido"));
		imprimirLista();
		//Map y Collector.toList
		List<String> listaString = listUser.stream().map(e->e.getNombre()).collect(Collectors.toList());
		listaString.stream().forEach(a->System.out.println(a));
		//Filter
		System.out.println("--------------------------Filters--------------------------");
		setUpUser();
		List<User> usersFilter = listUser.stream()
				.filter(e->e.getNombre() != "Allari")
				.filter(e->e.getId() < 3)
				.collect(Collectors.toList());
		usersFilter.stream().forEach(e->System.out.println(e.getId() + " " + e.getNombre()));
		//FindFirst
		System.out.println("--------------------------Find First--------------------------");
		setUpUser();
		User user = listUser.stream().filter(e->e.getNombre() == "Josei")
				.findFirst().orElse(null);
		System.out.println(user.getId() + " " + user.getNombre());
		//FlatMap
		System.out.println("--------------------------Flat Map--------------------------");
		List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Allari","Olivia","Allarito")),
						new ArrayList<String>(Arrays.asList("Nathalie","Olivita"))));
		List<String> nombreUnicaLista = nombresVariasListas.stream()
				.flatMap(e->e.stream())
				.collect(Collectors.toList());
		nombreUnicaLista.stream().forEach(e->System.out.println(e));
		//Peek
		System.out.println("--------------------------Peek--------------------------"); //funciona como el foreach
		setUpUser();
		List<User> user2 = listUser.stream()
				.peek(e -> e.setNombre(e.getNombre() + " Apellido"))
				.collect(Collectors.toList());
		user2.stream().forEach(e -> System.out.println(e.getNombre()));
		//Count
		System.out.println("--------------------------Count--------------------------"); //contar
		setUpUser();
		Long numeroFiltrado = listUser.stream()
				.filter(e -> e.getId() < 3)
				.count();
		System.out.println(numeroFiltrado);
		//Skip y Limit
		System.out.println("--------------------------Skip y Limit--------------------------"); //Saltar y limitar
		String[] abc = {"a","b","c","d","e","f","g","h","i","j"};
		List<String> abcFilter = Arrays.stream(abc)
				.skip(2)
				.limit(4)
				.collect(Collectors.toList());
		abcFilter.stream().forEach(e-> System.out.println(e));
		//Sorted
		System.out.println("--------------------------Sorted--------------------------"); //Ordenamiento 
		setUpUser();
		listUser = listUser.stream().sorted(Comparator.comparing(User::getNombre)).collect(Collectors.toList());
		imprimirLista();
		//Min y Max
		System.out.println("--------------------------Min y Max--------------------------");
		setUpUser();
		User userMin = listUser.stream().min(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println(userMin.getId());
		User userMax = listUser.stream().max(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println(userMax.getId());
		//Distinct
		System.out.println("--------------------------Distinct--------------------------");//Elimina elementos duplicados
		String[] abc2 = {"a","b","c","d","e","f","g","h","i","j","a","b","c","d"};
		List<String> abcFilter2 = Arrays.stream(abc2)
				.distinct().collect(Collectors.toList());
		abcFilter2.stream().forEach(e->System.out.println(e));
		//allMatch (Verifica si el predicado es verdadero)
		//anyMatch (Verifica si al menos un valor de el predicado es verdadero)		
		//noneMatch (Verifica si ningun elemento pasa el predicado)
		System.out.println("--------------------------allMatch, anyMatch, noneMatch--------------------------");
		List<Integer> listaNumeros = Arrays.asList(100,300,900,5000);
		boolean allMatch = listaNumeros.stream().allMatch(e -> e>301);
		System.out.println(allMatch);
		boolean anyMatch = listaNumeros.stream().anyMatch(e -> e>301);
		System.out.println(anyMatch);
		boolean noneMatch = listaNumeros.stream().noneMatch(e -> e > 10000);
		System.out.println(noneMatch);
		//Sum  realiza suma
		//Avarege realiza la media
		//range crea una lista de elemetos de un numero inicial o uno final 
		System.out.println("--------------------------Sum Avarege range--------------------------");
		setUpUser();
		double result = listUser.stream().mapToInt(User::getId)
				.average()
				.orElse(0);
		System.out.println(result);
		
		result = listUser.stream().mapToInt(User::getId).sum();
		System.out.println(result);
		
		System.out.println(IntStream.range(0, 100).sum());
		//Reduce // Combina el stream en un unico resultado
		System.out.println("--------------------------Reduce--------------------------");
		setUpUser();
		int numero = listUser.stream().map(User::getId)
				.reduce(0, Integer::sum);
		System.out.println(numero);
		//Joining Recompila concatenando la sequencia de chasr secuency y el resultado lo muestra en una cadena
		System.out.println("--------------------------Joining--------------------------");
		setUpUser();
		String names = listUser.stream()
				.map(User::getNombre)
				.collect(Collectors.joining(" - "))
				.toString();
		System.out.println(names);
		//toSet Devuelve colector que acumula los elementos de entrada en un nuevo set no garantiza ordenamiento
		//      pero garantiza que no hay datos repetidos
		System.out.println("--------------------------toSet--------------------------");
		setUpUser();
		Set<String> setNames = listUser.stream()
				.map(User::getNombre)
				.collect(Collectors.toSet());
		setNames.stream().forEach(e -> System.out.println(e));
		//SummarizingDouble Devuelve estadisticas en una variable DoubleSummaryStatistics
		System.out.println("--------------------------summarizingDouble--------------------------");
		setUpUser();
		DoubleSummaryStatistics statistics = listUser.stream().collect(Collectors.summarizingDouble(User::getId));
		System.out.println(statistics.getAverage() + " " +statistics.getMax() + " "+ statistics.getMin()
		              +" " +statistics.getCount() + " " + statistics.getSum());
		
		DoubleSummaryStatistics statistics1 = listUser.stream()
				.mapToDouble(User::getId)
				.summaryStatistics();
		System.out.println(statistics1.getAverage() + " " +statistics1.getMax() + " "+ statistics1.getMin()
        +" " +statistics1.getCount() + " " + statistics1.getSum());
		
		//partitioningBy Divide en dos un grupo que cumplen con la sentencia y otro grupo que no la cumple
		System.out.println("--------------------------partitioningBy--------------------------");
		setUpUser();
		List<Integer> numeros = Arrays.asList(5,7,34,56,2,3,67,4,98);
		Map<Boolean,List<Integer>> esMayor = numeros.stream().collect(Collectors.partitioningBy(e -> e > 10));
		esMayor.get(true).stream().forEach(e -> System.out.println(e));
		esMayor.get(false).stream().forEach(e -> System.out.println(e));
		//groupingBy Se debe de indicar el elemento por el cual se quiere agrupar
		System.out.println("--------------------------groupingBy--------------------------");
		setUpUser();
		Map<Character, List<User>> grupoAlfabetico = listUser.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		grupoAlfabetico.get('A').stream().forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('O').stream().forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('N').stream().forEach(e -> System.out.println(e.getNombre()));
		
		//Mapping Convierte una lista de objetos en otra lista de objetos que querramos
		System.out.println("--------------------------mapping--------------------------");
		setUpUser();
		List<String> personas = listUser.stream()
				.collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		personas.stream().forEach(e -> System.out.println(e));
		
		//Stream Paralelo ejecuta operaciones de stream en varios hilos
		System.out.println("--------------------------Stream Paralelo--------------------------");
		setUpUser();
		long tiempo1 = System.currentTimeMillis();
		listUser.stream().forEach(e -> convertirAMayusculas(e.getNombre()));
		long tiempo2 = System.currentTimeMillis();
		System.out.println("Normal: "+ (tiempo2-tiempo1));
		
		tiempo1 = System.currentTimeMillis();
		listUser.parallelStream().forEach(e -> convertirAMayusculas(e.getNombre()));
		tiempo2 = System.currentTimeMillis();
		System.out.println("Paralelo: " + (tiempo2-tiempo1));
		
		
		
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	private static void setUpUser() {
		listUser = new ArrayList<>();
		listUser.add(new User(1,"Allari"));
		listUser.add(new User(2,"Olivia"));
		listUser.add(new User(3,"Josei"));
		listUser.add(new User(4,"Nathalie"));
		listUser.add(new User(5,"Allarito"));
		listUser.add(new User(6,"Olivita"));
	}
	
	private static void imprimirLista() {
		listUser.stream().forEach(e->System.out.println(e.getId() + " " +e.getNombre()));
	}

}
