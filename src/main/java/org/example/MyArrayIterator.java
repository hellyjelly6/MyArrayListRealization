package org.example;

import java.util.Iterator;

/**
 * A custom iterator implementation for arrays.
 *
 * This class provides a way to iterate an array of elements of type E.
 *
 * It implements the {@link Iterator} interface, allowing for standard iteration operations.
 * @param <E> the type of elements in the array
 */
public class MyArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    /**
     * Constructor for MyArrayIterator.
     *
     * @param values the array to be iterated
     */
    public MyArrayIterator(E[] values){
        this.values = values;
    }

    /**
     * Checks if there is a next element in the {@code values} array.
     *
     * @return {@code true} if there is a next element; {@code false} if there are no more elements.
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public E next() {
        return values[index++];
    }

}
