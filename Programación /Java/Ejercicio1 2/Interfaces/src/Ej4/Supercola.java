package Ej4;

import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.Queue;

public class Supercola implements Cola {
	private Queue<Integer> cola1;
    private Queue<Integer> cola2;

    public Supercola() {
        cola1 = new LinkedList<>();
        cola2 = new LinkedList<>();
    }

    @Override
    public void encolar(int elemento) {
        encolarEnCola1(elemento);
    }

    public void encolarEnCola1(int elemento) {
        cola1.offer(elemento);
        mostrarEstado();
    }

    public void encolarEnCola2(int elemento) {
        cola2.offer(elemento);
        mostrarEstado();
    }

    @Override
    public Integer desencolar() {
        return desencolarDeCola1();
    }

    public Integer desencolarDeCola1() {
        if (!((AbstractCollection<Integer>) cola1).isEmpty()) {
            Integer elemento = cola1.poll();
            mostrarEstado();
            return elemento;
        } else {
            return desencolarDeCola2();
        }
    }

    public Integer desencolarDeCola2() {
        if (!((AbstractCollection<Integer>) cola2).isEmpty()) {
            Integer elemento = cola2.poll();
            mostrarEstado();
            return elemento;
        } else {
            return null;
        }
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado de la cola1: " + cola1);
        System.out.println("Estado de la cola2: " + cola2);
    }
}
