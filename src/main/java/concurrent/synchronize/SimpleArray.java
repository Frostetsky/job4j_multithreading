package concurrent.synchronize;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static int iteratorCount = 0;

    public SimpleArray() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public void add(T model) {
        if (index == array.length) {
            Object[] newarray = new Object[array.length + 15];
            System.arraycopy(array, 0, newarray, 0, array.length);
            array = newarray;
        }
        this.array[index++] = model;
        iteratorCount++;
    }

    @SuppressWarnings("unchecked")
    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) this.array[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < index;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[iteratorIndex++];
            }
        };
    }
}
