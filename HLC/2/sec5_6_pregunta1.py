# Este programa evalúa la hipotenusa
# a y b son las longitudes de los catetos.
cateto_a = float(input("Introduce el valor del cateto a: "))
cateto_b = float(input("Introduce el valor del cateto b: "))
calc_hipotenusa = (cateto_a ** 2 + cateto_b ** 2) ** 0.5
print("La hipotenusa es:", calc_hipotenusa)
