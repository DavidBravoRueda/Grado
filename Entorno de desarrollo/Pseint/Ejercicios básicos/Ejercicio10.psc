Algoritmo Ejercicio10
	
	Definir num1 Como Entero
	Escribir "Dime un día"
	Leer num1
	
	Definir num2 Como Entero
	Escribir "Dime un més"
	Leer num2
	
	Definir num3 Como Entero
	Escribir "Dime un año"
	Leer num3
	
	
	
	Segun (num3 > 0) Hacer
		opcion_1:
			si num2 = 1 Entonces
				mes = "enero"
			FinSi
		opcion_2:
			si num2 = 2 Entonces
				mes = "febrero"
			FinSi 
		opcion_3:
			si num2 = 3 Entonces
				mes = "marzo"
			FinSi
			
		opcion4:
			si num2 = 4 Entonces
				mes = "abril"
			FinSi
			
		opcion5:
			si num2 = 5 Entonces
				mes = "mayo"
			FinSi
			
		opcion6:
			si num2 = 6 Entonces
				mes = "junio"
			FinSi
			
		opcion7:
			si num2 = 8 Entonces
				mes = "agosto"
			FinSi
			
		opcion8:
			si num2 = 8 Entonces
				mes = "agosto"
			FinSi
			
		opcion9:
			si num2 = 9 Entonces
				mes = "septiembre"
			FinSi
			
		opcion10:
			si num2 = 10 Entonces
				mes = "octubre"
			FinSi
			
		opcion11:
			si num2 = 11 Entonces
				mes = "noviembre"
			FinSi
			
		opcion12:
			si num2 = 12 Entonces
				mes = "diciembre"
			FinSi
		De Otro Modo:
			Escribir "psos"
	Fin Segun
	
	Escribir num1 " de " mes " de " num3
	
	
	
	
FinAlgoritmo
