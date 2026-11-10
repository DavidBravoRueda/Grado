from datetime import datetime

fecha1_str = input("Ingrese la primera fecha (aaaa/mm/dd): ")
fecha2_str = input("Ingrese la segunda fecha (aaaa/mm/dd): ")

formato = "%Y/%m/%d"

try:
    fecha1 = datetime.strptime(fecha1_str, formato)
    fecha2 = datetime.strptime(fecha2_str, formato)

    if fecha1 < fecha2:
        print("La primera fecha es anterior a la segunda.")
    elif fecha1 > fecha2:
        print("La primera fecha es posterior a la segunda.")
    else:
        print("Las dos fechas son iguales.")

except ValueError:
    print("Error: El formato de la fecha ingresada no es válido. Debe ser aaaa/mm/dd.")
