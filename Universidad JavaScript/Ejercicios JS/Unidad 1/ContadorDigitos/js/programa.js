document.write("Programa para contar el número de digitos de un entero positivo: <br/>");

var num = prompt("Proporciona un número entero positivo",1);
document.write("El número proporcionado fue: "+num);
var contador_digitos = 0;

while (num >= 1) {
  num = num/10;
  contador_digitos ++;
}

document.write("<br/>El número proporcionado contiene "+contador_digitos +" digitos");
