Algoritmo Ejerciciointeraccion4
	
	Definir suma, numero Como Entero
	
    suma = 0
	
    Para numero = 1 Hasta 20
        Si (numero % 5 = 0) O (numero % 7 = 0) Entonces
            suma = suma + numero
        Fin Si
    Fin Para
	
    Escribir "La suma de los números múltiplos de 5 o 7 entre 1 y 20 es:" , suma
	
FinAlgoritmo
