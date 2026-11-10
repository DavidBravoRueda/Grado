Algoritmo Ejercicio7
	
	Definir num1 Como Entero
	Escribir "Dime el mes de la compra"
	Leer num1
	
	Definir num2 Como Entero
	Escribir "Dime el importe de la compra"
	Leer num2
	
	si num1 = 10 Entonces
		solución <- num2 - ((num2 *15) / 100)
		Escribir " El precio será de " solucion " euros"
	SiNo
		solucion <- num2
		Escribir " El precio será de " solucion " euros"
	FinSi
	
FinAlgoritmo
