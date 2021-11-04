document.write("Programa para el manejo de tipo de datos: <br/>");

//String
var cadena = "Hola desde javascript";
document.write("Valor de cadena: "+cadena+"<br/>");

//Numeros
var num1 = 15;
var num2 = parseInt("20");
var num3 = num1 + num2;
document.write("Valor de num1: "+ num1+ "<br/>");
document.write("Valor de num2: "+ num2+ "<br/>");
document.write("Valor de num3: "+ num3+ "<br/>");

//Boolean
var bandera = true;
var resultado = (num1 == num2);
document.write("Valor de bandera: "+ num1+ "<br/>");
document.write("Valor de rasultado: "+ resultado+ "<br/>");

//Null
var tipoNull = null;
document.write("Valor de tipoNull: "+ tipoNull+ "<br/>");

//No definido
var tipoIndefinido;
document.write("Valor de tipoIndefinido: "+ tipoIndefinido+ "<br/>");

//Conocer el tipo de dato
resultado = (typeof num1 == "number");
document.write("¿Es número? " + resultado + "<br/>");

resultado = (typeof cadena == "String");
document.write("¿Es cadena? " + resultado + "<br/>");

resultado = (typeof bandera == "Boolean");
document.write("¿Es bandera? " + resultado + "<br/>");
