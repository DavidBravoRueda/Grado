frase = input("Ingrese una frase: ")

frase = frase.lower()

vocales = "aeiou"

for vocal in vocales:
    cantidad = frase.count(vocal)
    print(f"La vocal '{vocal}' aparece {cantidad} veces.")
