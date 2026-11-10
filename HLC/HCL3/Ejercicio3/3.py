# Apartado 1 *********************************
edad = int(input("Introduce tu edad: "))
if edad > 18:
    print("Eres mayor de edad")
## Fin Apartado 1 ******************************

# Apartado 2 *********************************
num_positivo = int(input("Introduce un número: "))
if num_positivo > 0:
    print("El número es positivo")
elif num_positivo < 0:
    print("El número es negativo")
else:
    print("El número es cero")
## Fin Apartado 2 ******************************

# Apartado 3 *********************************
numeros = [10, 20, 30, 40]
for i, num in enumerate(numeros):
    if num == 30:
        print(f"El número 30 está en la lista, en la posición {i}")
        break
for i, num in enumerate(numeros):
    if num == 12:
        print("El número 12 está en la lista, en la posición", i)
        break
else:
    print("El elemento no se encuentra en la lista")
## Fin Apartado 3 ******************************
