window.onload = iniciaDatos;

function iniciaDatos() {
  document.getElementById("link").onclick = validaSalir;
  document.getElementById("linkSearch").onclick = busqueda;
}

function validaSalir() {
  if(confirm("Desea salir del sitio?")){
    alert("Nos vamos a Google");
    return true;
  }else{
    alert("Nos quedamos en el sitio");
    return false;
  }
}

function busqueda() {
  //Con la funcion prompt capturamos información del usuario
  var respuesta = prompt("Escribe la cadena a buscar:","");
  //si hubo una respuesta concatenamos la cadena a buscar al link de google
  if(respuesta){
    alert("Tu respuesta fue:" + respuesta);
    //el operador this nos sirve para referenciar al elemento
    // que provoco el evento, en este caso el elemento con
    //identificador "linkSearch" y concatenamos la respuesta
    //como un parametro de una peticion get
    var nuevoLink = this+"search?q="+respuesta;
    alert("Nuevo link:" + nuevoLink);
    //redireccionamos el link
    window.location = nuevoLink;
    //regresamos false, sino nos lleva al link originalmente
    return false;
  }else{
    alert("No proporcionaste ninguna cadena a buscar");
    return false;
  }
}
