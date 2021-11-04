function sucesionFibonacci(entrada) {
  limpiar();
  /*
    Manejo de la secuencia de Fibonacci
    Valor a = tiene el valor actual
    Valor b = tiene el valor nuevo
    Valor c = tiene el valor siguiente
  */
  // asignamos los valores iniciales
  var a = 0;
  var b = 1;
  var c = null;
  var noMaximoElementos = 100;
  var elementosSerie = entrada.value;
  if (elementosSerie > noMaximoElementos) {
    imprimir("Debes probar con menos de 100 elementos");
    return;
  }
  //Imprimir los valores iniciales
  imprimir(a);
  imprimir(b);

  //Realizamos la iteración
  for (var i = 0; i < elementosSerie - 2; i++) {
    c = a +b ; //Valor siguiente
    //respaldo de valores
    a = b;
    b = c;
    imprimir(c);
  }
}

function imprimir(valor) {
  document.getElementById("resultado").innerHTML += valor + " ";

}

function limpiar() {
  document.getElementById("resultado").innerHTML = "";
}
