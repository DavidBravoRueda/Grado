respuesta='s'
while respuesta.lower()=='s':
    numero=int(input("Introduce un número par: "))
    
    if numero%2==0:
        print("Número correcto")
    
    else:
        print("Número incorrecto. Debes de introducir un número par")
    
    respuesta=input("Para introducir un número par pulsa S/s. cualquier otra tecla para salir: ")
