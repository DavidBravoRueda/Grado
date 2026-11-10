print("Escribe una cadena:")
cadena = str(input())

longitud = len(cadena)
print(f"La longitus de la cadena es: {longitud}")

cadenaUsuario = 'usuario' + cadena
print(f"La cadena con 'usuario' al comienzo es: {cadenaUsuario}")

if '@' in cadena:
    print("La cadena es un correo electrónico")
else:
    print("La cadena no es un correo electrónico")