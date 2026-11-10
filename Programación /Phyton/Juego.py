informacionjuegos = {
  "1": "Información sobre Pacman: El juego consiste en conducir a Pac-Man, una bola amarilla que abre y cierra la boca, por un laberinto. Suma puntos cuando come aquello que encuentra a su paso, bolitas y diferentes frutas, pero debe esquivar a cuatro fantasmas.",
  "2": "Información sobre Tetris:  El tetris consiste en ir encajando piezas de diferentes formas y tamaños que caen desde la parte superior de la pantalla para completar un muro sin dejar huecos.",
  "3": "Información sobre Mario Bros: El juego describe las aventuras de los hermanos Mario y Luigi. En esta ocasión ambos deben rescatar a la Princesa Peach del Reino Champiñón que fue secuestrada por el rey de los Koopas, Bowser.",}
  


sonidoactivado = True


def mostrarmenu():
    print("Menú de Videojuegos:")
    print("1. Pacman")
    print("2. Tetris")
    print("3. Mario Bros")
    print("4. Ajustes")
    print("5. Salir")


def mostrarinformacion(juego):
    if juego in informacionjuegos:
        print(informacionjuegos[juego])
    else:
        print("Opción no válida. Por favor, elija una opción válida.")

def configurarajustes():
    global sonidoactivado
    print("Ajustes:")
    print("1. Activar/Desactivar sonido")
    print("2. Volver al menú principal")
    opcionajustes = input("Elija una opción de ajustes (1,2): ")
    
    if opcionajustes == "1":
        sonidoactivado = not sonidoactivado
        estadosonido = "activado" if sonidoactivado else "desactivado"
        print(f"Sonido {estadosonido}.")
    elif opcionajustes == "2":
        return
    else:
        print("Opción no válida. Por favor, elija una opción válida.")


while True:
    mostrarmenu()
    opcion = input("Elija una opción (1,2,3,4,5): ")
    
    if opcion == "5":
        print("Has salido")
        break
    
    if opcion == "4":
        configurarajustes()
    elif opcion in informacionjuegos:
        if sonidoactivado:
            mostrarinformacion(opcion)
        else:
            print("El sonido está desactivado. No se puede reproducir la información del juego.")
    else:
        print("Opción no válida. Por favor, elija una opción válida.")
