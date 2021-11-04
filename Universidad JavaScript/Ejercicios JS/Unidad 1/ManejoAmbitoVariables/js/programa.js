var nombre = null // variable global
function mostrarNombre(parametro) {
  nombre = parametro.value;
  var saludo = "Hola "+ nombre.toUpperCase();
  document.getElementById('resultado').innerHTML = saludo;
}

function saludarLocal(parametro) {
  var nombre = parametro;
  alert("Hola "+ nombre + " (local)");
  alert("Hola "+ this.nombre) + "(global)");
}

function saludarGlobal() {
  alert("Hola "+nombre);
}
