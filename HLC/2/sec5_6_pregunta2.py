# Este programa convierte un número de segundos introducido por el usuario en horas, minutos y segundos.
# Además, muestra los resultados en dos formatos diferentes utilizando operadores de cadenas.
print("Introduzca el número de segundos para calcular:")
segundos_totales = int(input())

horas = segundos_totales // 3600
minutos = (segundos_totales % 3600) // 60
segundos = segundos_totales % 60

print(f"La cantidad corresponde a: {horas} horas, {minutos} minutos y {segundos} segundos")
print(f"{'*' * 9} {horas} : {minutos} : {segundos} {'*' * 9}")
