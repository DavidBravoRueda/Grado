print("Precio del producto: ")
precio = float(input())
print("Importe dado: ")
importe = float(input())

vuelta = importe - precio

if precio > importe:
    print("Falta dinero")
else:
    vueltaRedondeada = round(vuelta)
    
    if vuelta > vueltaRedondeada:
        centimos = (vuelta - vueltaRedondeada) * 100
        print(f"El cambio es {vueltaRedondeada} euros y {centimos} céntimos.")
    elif vuelta < vueltaRedondeada:
        centimos = (vuelta - (vueltaRedondeada - 1)) * 100
        print(f"El cambio es {vueltaRedondeada - 1} euros y {centimos} céntimos.")
    else:
        print(f"El cambio es {vueltaRedondeada} euros y 0 céntimos.")