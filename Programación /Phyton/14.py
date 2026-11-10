cadena = 'hunos.ugr.es:X-DSPAM:0.8475'

campos = cadena.split(':')

servidor = campos[0]
valorNumerico = campos[2]

print(f"El nombre del servidor es : {servidor}")
print(f"El valor numérico es: {valorNumerico}")