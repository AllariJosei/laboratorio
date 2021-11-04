function manejoMatrices() {
  var dato = null;
  /*
    Definicion Matriz a
    [a b c]
    [d e f]
    [g h i]
  */

  //Arreglos individuales
  var a1 = new Array();
  a1[0] = "a";
  a1[1] = "b";
  a1[2] = "c";

  //Renglon 1
  var a2 = new Array();
  a2[0] = "d";
  a2[1] = "e";
  a2[2] = "f";

  //Renglon 2
  var a3 = new Array();
  a3[0] = "g";
  a3[1] = "h";
  a3[2] = "i";

// Se crea el arreglo de areglos
  var a = new Array();
  a[0] = a1;
  a[1] = a2;
  a[2] = a3;

  //Recorrer la Matriz
  for (var i = 0; i < a.length; i++) {
    //Recorrer cada arreglo
    for (var j = 0; j < a[i].length; j++) {
      //Imprimir cada elemento del arreglo
      dato = a[i][j];
      imprimir(dato);
    }
    imprimir("<br/>");
  }
}

function imprimir(valor) {
  document.getElementById("resultado").innerHTML += valor + " ";
}

function limpiar() {
  document.getElementById("resultado").innerHTML = "";
}
