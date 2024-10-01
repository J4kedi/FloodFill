package floodFillPilha;

public class Pilha<T> {
    private int top = -1;
    private T[] data;

    @SuppressWarnings("unchecked")
    public Pilha (int size) {
        this.data = (T[]) new Object[size];
    }

    public void push(T data) {
        this.data[++top] = data;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T v = data[top];
        data[top--] = null;
        return v;
    }

    public void clear() {
        if (isEmpty())
            throw new IllegalArgumentException("Pilha está vazia!");
        for(T data: this.data)
            this.data[top--] = null;
        top = -1;
    }

    public boolean isFull() {
        return top + 1 == data.length;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
