
import math

while True:
    a_input = input("Introduce el valor de 'a': ")
    if a_input.isdigit():
        a = int(a_input)
        break
    else:
        print("Introduce un número entero válido para 'a'.")

while True:
    b_input = input("Introduce el valor de 'b': ")
    if b_input.isdigit():
        b = int(b_input)
        break
    else:
        print("Introduce un número entero válido para 'b'.")

c = math.sqrt(a**2 + b**2)

print(f"El valor de c para a={a} y b={b} es: {c}")

examples = [(4, 9), (23, 12)]
for example_a, example_b in examples:
    example_c = math.sqrt(example_a**2 + example_b**2)
    print(f"El valor de c para a={example_a} y b={example_b} es: {example_c}")