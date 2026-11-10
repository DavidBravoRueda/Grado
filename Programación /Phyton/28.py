valor_centimos = int(input("Ingrese el valor en céntimos de la moneda: "))

numero_monedas = int(input("Ingrese el número de monedas: "))

total_euros = (valor_centimos * numero_monedas) / 100

print(f"Tengo {total_euros:.2f}€ en {numero_monedas} monedas de {valor_centimos} céntimos.")
