package reghzy.collections;

import java.util.Iterator;

public class Array<E> implements Iterable<E> {
    private final Object[] elements;

    public Array(int size) {
        elements = new Object[size];
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void set(int index, E value) {
        elements[index] = value;
    }

    public E swap(int index, E value) {
        Object previous = elements[index];
        elements[index] = value;
        return (E) previous;
    }

    public void swap(int oldIndex, int newIndex) {
        Object oldObj = elements[oldIndex];
        Object newObj = elements[newIndex];
        elements[oldIndex] = newObj;
        elements[newIndex] = oldObj;
    }

    public int length() {
        return elements.length;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator<E>();
    }

    private class ArrayIterator<I> implements Iterator<I> {
        private int index;

        public boolean hasNext() {
            return index < (elements.length - 1);
        }

        public I next() {
            return (I) elements[index];
        }

        public void remove() {
            elements[index] = null;
        }
    }
}
