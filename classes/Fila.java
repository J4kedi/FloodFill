package classes;

import java.util.Arrays;

public class Fila<T> {
    private int top = 0;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public Fila(int size) {
        this.data = (T[]) new Object[size];
    }

    public int getBase() {
        return base;
    }

    public int getTop() {
        return top;
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }

        top = 0;
        base = 0;
    }

    public void add(T n) {
        if (!isFull()) {
            data[top] = n;
            System.out.println("Adicionado: " + data[top]);
            top = move(top);
        } else {
            throw new IllegalArgumentException("Fila cheia!");
        }
    }

    public T rm() {
        if (data[base] == null) {
            throw new IllegalArgumentException("Fila vazia!");
        }
        T v = data[base];
        System.out.println("Removido: " + data[base]);
        data[base] = null;
        base = move(base);
        return v;
    }

    public int move(int pos) {
        return (pos + 1) % data.length;
    }

    public boolean isFull() {
        return top == base && base != 0;
    }

    public boolean isEmpty() {
        return top == base && base == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}