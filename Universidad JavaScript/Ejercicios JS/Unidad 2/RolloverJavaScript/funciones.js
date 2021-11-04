window.onload = cargarImagenes;

function cargarImagenes() {
  for (var i = 0; i < document.images.length; i++) {
    if (document.images[i].parentNode.tagName == "A") {
      configuraRollover(document.images[i]);
    }
  }
}

function configuraRollover(imagen) {
  imagen.imagenOff = new Image();
  imagen.imagenOff.src = "boton_off.jpg";
  imagen.onmouseout = cambiaOff;

  imagen.imagenOn = new Image();
  imagen.imagenOn.src = "boton_on.jpg";
  imagen.onmouseover = cambiaOn;
}

/* Estsa funciones se ejecutan segun el evento que se dispare pero no
al iniciar la pagina, sino dependen del boton que se presione, son
conocidas como handlers*/
//Se asocio al evento onmouseout
function cambiaOff() {
  this.src = this.imagenOff.src;
}

function cambiaOn() {
  this.src = this.imagenOn.src;
}
