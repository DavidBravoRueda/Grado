Algoritmo Ejerciciocondicional3
	
	Definir num1 Como real
		Escribir "Dame un valor de x"
		Leer num1
			si num1 < 0 Entonces
				Escribir "f(x)=0"
			SiNo
				si num1 >= 0 Y num1 <= 1 Entonces
					Escribir "f(x)=x"
				SiNo
					si num1 > 1 Y num1 <= 2 Entonces
						
						Escribir "f(x)=2-x"
					SiNo
						si num1 > 2 Entonces
							Escribir "f(X)=0"
						FinSi
					FinSi
				FinSi
			FinSi
	
FinAlgoritmo
