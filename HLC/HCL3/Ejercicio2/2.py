# Apartado 1 *********************************
lista_ascendente = list(range(1, 51))
print("Lista ascendente:", lista_ascendente)
lista_ascendente = [x + 3 for x in lista_ascendente]
print("Lista ascendente después de sumar 3:", lista_ascendente)
## Fin Apartado 1 ******************************

# Apartado 2 *********************************
lista_descendente = list(range(50, 0, -1))
print("Lista descendente:", lista_descendente)
lista_descendente = [x + 10 for x in lista_descendente]
print("Lista descendente después de sumar 10:", lista_descendente)
## Fin Apartado 2 ******************************

# Apartado 3 *********************************
lista_unida = lista_ascendente + lista_descendente
print("Primeros 10 elementos:")
for i in range(10):
    print(f"Posición: {i+1}, valor: {lista_unida[i]}")

print("Últimos 10 elementos:")
for i in range(1, 11):
    print(f"Posición: {len(lista_unida) - i + 1}, valor: {lista_unida[-i]}")
## Fin Apartado 3 ******************************
