precio = float(input("Introduce el precio del producto (en euros): "))
pagado = float(input("Introduce la cantidad de dinero entregada (en euros): "))

cambio = int(round((pagado - precio) * 100))

if cambio < 0:
    print("El dinero entregado no es suficiente.")
else:
    print(f"El cambio total es: {cambio / 100}€")

    if cambio >= 200:
        monedas_2e = cambio // 200
        print(f"{monedas_2e} moneda(s) de 2.00€")
        cambio %= 200

    if cambio >= 100:
        monedas_1e = cambio // 100
        print(f"{monedas_1e} moneda(s) de 1.00€")
        cambio %= 100

    if cambio >= 50:
        monedas_50c = cambio // 50
        print(f"{monedas_50c} moneda(s) de 0.50€")
        cambio %= 50

    if cambio >= 20:
        monedas_20c = cambio // 20
        print(f"{monedas_20c} moneda(s) de 0.20€")
        cambio %= 20

    if cambio >= 10:
        monedas_10c = cambio // 10
        print(f"{monedas_10c} moneda(s) de 0.10€")
        cambio %= 10

    if cambio >= 5:
        monedas_5c = cambio // 5
        print(f"{monedas_5c} moneda(s) de 0.05€")
        cambio %= 5

    if cambio >= 2:
        monedas_2c = cambio // 2
        print(f"{monedas_2c} moneda(s) de 0.02€")
        cambio %= 2

    if cambio >= 1:
        monedas_1c = cambio // 1
        print(f"{monedas_1c} moneda(s) de 0.01€")