import math

g = 9.8 

m = float(input("Introduce la masa del cuerpo (en kg): "))
h = float(input("Introduce la altura del cuerpo (en metros): "))

energia_potencial = m * g * h

velocidad_impacto = math.sqrt(2 * g * h)

print(f"Energía potencial: {energia_potencial:.2f} J")
print(f"Energía cinética justo antes del impacto: {energia_potencial:.2f} J")
print(f"Velocidad de impacto: {velocidad_impacto:.2f} m/s")