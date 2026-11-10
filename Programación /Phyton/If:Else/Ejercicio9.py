print("Escribe un número")
num1=int(input())
print("Escribe otro número")
num2=int(input())
if num1>=num2:
  if num1%num2==0:
    print(f"{num1} es múltiplo de {num2}")
  else:
    print(f"{num1} no es múltiplo de {num2}")
else:
  if num2%num1==0:
    print(f"{num2} es múltiplo de {num1}")
  else:
    print(f"{num2} no es múltiplo de {num1}")




