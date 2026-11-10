Algoritmo Ejerciciobucle6
	
	Definir N Como Entero
	Definir media Como Real
	Definir contador Como Entero
	Definir acumulador Como Entero
	contador <- 0 
	acumulador <- 0 
	N <- 0 
	
	Mientras N <> -1 Hacer
		Leer N
		
		si n <> -1 Entonces
			acumulador <- acumulador + n
			contador <- contador + 1
		FinSi
	FinMientras
	
	media <- acumulador / contador
	
	Escribir "Media: " media
	
FinAlgoritmo
