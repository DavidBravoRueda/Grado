Algoritmo Ejercicio8
    Definir numero, resultado Como Entero
	Escribir "Dame un número"
    Leer numero
	
    resultado = numero % 2
	
    Si numero = 0 Entonces
        Escribir "El número no es ni par ni impar"
    Sino
        Si resultado = 0 Entonces
            Escribir "El número es par"
        Sino
            Escribir "El número es impar"
        Fin Si
    Fin Si
FinAlgoritmo
