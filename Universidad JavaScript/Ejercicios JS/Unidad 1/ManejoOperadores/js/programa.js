document.write("Programá para el manejo de Operadores:<br/>");

//Operador = Se utiliza para asignar un valor
var x = 5 ;
var y;
y= 6;
document.write("Valor de x: "+ x + "<br/>");
document.write("Valor de y: "+ y + "<br/>");

//Operador  + se utiliza para sumar
var z = x + y;
document.write("Valor de z: "+ z + "<br/>");

//Operador ++ incrementa en uno una variable
x++;
document.write("Valor de x: "+ x + "<br/>");

//Operador -- decrementar en uno una variable
y--;
document.write("Valor de y: "+ y + "<br/>");

//Operador +=
x += y;
document.write("Valor de x: "+ x + "<br/>");

//Operador de oncatenacion + concatena si alguno de los valores es cadenas
var texto1 = "Global";
var texto2 = "Trap";
document.write("Valor de la concatenación: "+ texto1+" "+ texto2+ " "+ x +"<br/>");
