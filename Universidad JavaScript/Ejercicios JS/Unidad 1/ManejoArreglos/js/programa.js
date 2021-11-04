function manejoArreglos() {
  var lengua = null;
  //Definir el arreglos
  var lenguas = new Array();
  lenguas[0] = "Chino mandarin";
  lenguas[1] = "Español";
  lenguas[2] = "Ingles";
  lenguas[3] = "Hindi";

  //Recorremos el arreglo
  for (var i = 0; i < lenguas.length; i++) {
    lengua = lenguas[i];
    imprimir(lengua);
  }
}

function imprimir(valor) {
  document.getElementById("resultado").innerHTML += valor + " ";
}

function limpiar() {
  document.getElementById("resultado").innerHTML = "";
}
