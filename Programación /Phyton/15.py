# Leer el número como un entero
numero = int(input("Introduce un número entero de tres dígitos: "))

# Extraer los dígitos usando operaciones matemáticas
centenas = numero // 100          
decenas = (numero // 10) % 10    
unidades = numero % 10            

# Imprimir los dígitos separados por espacios
print(centenas, decenas, unidades)