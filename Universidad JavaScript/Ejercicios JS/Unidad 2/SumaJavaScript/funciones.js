function sumar() {
  /* Envolvemos todo el codigo en un bloque Try Catch para
  procesar la excepcion en caso de que haya ocurrido alguna*/
  try {
    //Pedimos el valor de el operando a
    var a = prompt("Valor a:","");
    //validamos parametro a, !a revisa si la cadena esta vacia o nula
    if (!a || isNaN(a)) {
      throw new Error("Valor invalido de a: "+a);
    }
    // pedimos el valor del operando b
    var b = prompt("Valor b:","");
    //Validamos parametro b, !b revisa si la cadena esta vacia o nula
    if (!b || isNaN(b)) {
      throw new Error("Valor invalido de b: "+b);
    }
    /*Hacemos la suma necesitamos convertir a Int los parametros
    con parseInt convierte a entero, si no es entero no va a realizar
    la suma sino concatena los valores*/
    var c = parseInt(a) + parseInt(b);
    alert("La suma es: "+c);
  } catch (e) {
    alert("El error es: "+ e.message);
  }
}
