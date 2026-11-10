valores_x = [0, 1, -1]
for x in valores_x:
    y = 3 * x**3 - 2 * x**2 + 3 * x - 1
    print(f"Para x = {x}, el valor de y es: {y}")

x_usuario = float(input("Introduce un valor para x: "))

y_usuario = 3 * x_usuario**3 - 2 * x_usuario**2 + 3 * x_usuario - 1
print(f"Para x = {x_usuario}, el valor de y es: {y_usuario}")
