Algoritmo Ejercicio9
	Escribir "¿Tienes prueba de acceso o bachillerato?"
	Leer Titulo
	
	si Minusculas(Titulo) = "bachillerato" Entonces
		Escribir "Puede cursar el títullo superior"
	SiNo
		si Minusculas(Titulo) = "prueba de acceso" Entonces
			Escribir "No puede cursar el título superior"
		FinSi
	FinSi
	
FinAlgoritmo
