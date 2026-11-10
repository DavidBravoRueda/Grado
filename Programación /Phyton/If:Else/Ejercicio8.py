print("Escribe un año")
num1=int(input())
print("Escribe otro año")
num2=int(input())
if int(num1)==2023:
  resultado=(num2)-2023
  print(f"Faltan {resultado} años para {num2}")
else:
  resultado=(num2)-(num1)
  print(f"De {num1} hasta {num2} van {resultado}")