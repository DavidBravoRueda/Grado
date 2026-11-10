import math

gravedad = 9.8

altura = float(input("Ingrese la altura desde la cual cae el objeto (en metros): "))

tiempo_impacto = math.sqrt((2 * altura) / gravedad)

print(f"El tiempo que tarda en impactar con el suelo es: {tiempo_impacto} segundos")