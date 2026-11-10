Algoritmo Ejercicio7
    Definir maximo como Entero
    Definir minimo como Entero
    Definir suma como Entero
    Definir contador como Entero
    maximo <- -INFINITO
    minimo <- +INFINITO
    suma <- 0
    contador <- 0
    
    Escribir "Ingrese números (0 para salir)"
    
    Repetir
        Escribir "Ingrese un número"
        Leer numero
        Si numero <> 0 Entonces
            Si numero > maximo Entonces
                maximo <- numero
            Fin Si
            Si numero < minimo Entonces
                minimo <- numero
            Fin Si
            suma <- suma + numero
            contador <- contador + 1
        Fin Si
    Hasta Que numero = 0
    
    Si contador > 0 Entonces
        media <- suma / contador
    Sino
        media <- 0
    Fin Si
    
    Escribir "Máximo:", maximo
    Escribir "Mínimo:", minimo
    Escribir "Media:", media
    
FinAlgoritmo
