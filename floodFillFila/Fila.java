package floodFillFila;

import java.util.Arrays;

public class Fila<T> {
    private int top = 0;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public Fila(int size) {
        this.data = (T[]) new Object[size];
    }

    public void clear() {
        for (int i = 0; i < data.length; i++)
            data[i] = null;
        top = 0;
        base = 0;
    }

    public void add(T n) {
        if (isFull())
            throw new IllegalArgumentException("Fila cheia!");
        data[top] = n;
        top = move(top);
    }

    public T rm() {
        if (isEmpty())
            throw new IllegalArgumentException("Fila vazia");
        T v = data[base];
        data[base] = null;
        base = move(base);
        if (top == 1) {
            base = 0;
            top = 0;
        }
        return v;
    }

    public T poll () {
        if (isEmpty())
            return null;
        T v = data[base];
        System.out.println("Removido: " + data[base]);
        data[base] = null;
        base = move(base);
        if (top == 1) {
            base = 0;
            top = 0;
        }
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