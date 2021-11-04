function mostrarNombre(parametro) {
  var nombre = parametro.value;
  var saludo = "Hola "+ nombre.toUpperCase();
  document.getElementById('resultado').innerHTML = saludo;
}
