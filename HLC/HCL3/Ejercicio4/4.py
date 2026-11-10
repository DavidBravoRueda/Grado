# Apartado 1 *********************************
filas = int(input("Introduce el número de filas (entre 1 y 4): "))
## Fin Apartado 1 ******************************

# Apartado 2 *********************************
columnas = int(input("Introduce el número de columnas (entre 1 y 4): "))
## Fin Apartado 2 ******************************

# Apartado 3 *********************************
print("Matriz:")
fila = 0
while fila < filas:
    columna = 0
    while columna < columnas:
        print(columna, end=" ")
        columna += 1
    print()
    fila += 1
## Fin Apartado 3 ******************************

# Apartado 4 *********************************
matriz_cuadrada = []
for fila in range(filas):
    matriz_cuadrada.append([columna for columna in range(columnas)])
    
print("Matriz cuadrada:", matriz_cuadrada)
## Fin Apartado 4 ******************************
