Algoritmo Diagrama5
	Definir num1 Como Entero
	Escribir 'Ingrese un año:'
	Leer num1
	Si (num1 MOD 4=0 Y num1 MOD 100<>0) O (num1 MOD 400=0) Entonces
		Escribir 'El año ', num1, ' es bisiesto.'
	SiNo
		Escribir 'El año ', num1, ' no es bisiesto.'
	FinSi
FinAlgoritmo
