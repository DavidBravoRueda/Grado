Algoritmo Ejercicio10
    
	Definir hora, minutos, segundos como Entero
	hora <- 0
    minutos <- 0
    segundos <- 0
	
    Repetir
        Limpiar Pantalla
        Escribir "Reloj Digital"
        Escribir hora, ":", minutos, ":", segundos
		
        
        segundos <- segundos + 1
        Si segundos >= 60 Entonces
            segundos <- 0
            minutos <- minutos + 1
            Si minutos >= 60 Entonces
                minutos <- 0
                hora <- hora + 1
                Si hora >= 24 Entonces
                    hora <- 0
                Fin Si
            Fin Si
        Fin Si
		
        Esperar 1 Segundos
    Hasta Que Falso 
FinAlgoritmo
