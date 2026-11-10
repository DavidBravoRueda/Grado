package Ej1;

import java.util.LinkedList;
import java.util.Queue;

public class Listacola implements Cola {
	public Queue<String> cola;
	
	public Listacola() {
		this.cola = new LinkedList<>();
	}

	@Override
	public void encolar(String elemento) {
		// TODO Auto-generated method stub
		cola.offer(elemento);
		// Se agrega un elemento a la cola usando offer. 
	}

	@Override
	public String desencolar() {
		// TODO Auto-generated method stub
		return cola.poll();
		// Se utiliza para quitar y devolver el elemento al frente de la cola.
	}

	@Override
	public boolean estavacia() {
		// TODO Auto-generated method stub
		return ((CharSequence) cola).isEmpty();
		// SE usa para verificar si una lista tiene elementyos o no.
	}

}

