package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * Realization of a dynamic array with sorting capabilities.
 * <p>
 * This class extends {@link MyQuickSort} and implements {@link MySimpleArray} interface.
 *
 * @param <E> the type of elements in this list, must implement {@link Comparable}
 */
public class MyArrayList<E> extends MyQuickSort<E> implements MySimpleArray<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    private E[] array;

    /**
     * Constructs a new list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is invalid
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity>0)
            this.array = (E[]) new Object[initialCapacity];
        else if(initialCapacity == 0)
            this.array = (E[]) new Object[DEFAULT_CAPACITY];
        else
            throw new IllegalArgumentException("Illegal capacity value");
    }

    /**
     * Constructs a new list with the default capacity.
     */
    public MyArrayList(){
         this.array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Appends the element to the end of this list.
     *
     * @param item element to be appended to this list
     * @return {@code true} if the element was successfully added
     */
    @Override
    public boolean add(E item) {
        if((size+1) >= array.length)
            array = resize(array, "increase");
        this.array[size++] = item;
        return true;
    }

    /**
     * Inserts the  element at the specified position in this list.
     * <p>
     * The array increases if the number of elements becomes larger than the size of the array.
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     * @return {@code true} if the element was successfully inserted
     */
    @Override
    public boolean add(int index, E item) {
        if((size+1)> array.length)
            array = resize(array, "increase");
        for (int i = size; i > index; i--) {
            this.array[i] = this.array[i-1];
        }
        this.array[index] = item;
        size++;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        return this.array[index];
    }

    /**
     * Removes the element at the specified position in this list.
     * <p>
     * The array is reduced if the size of the array becomes twice as large as the number of elements.
     * @param index the index of the element to be removed
     * @return {@code true} if the element was successfully removed
     */
    @Override
    public boolean remove(int index) {
        for (int i = index; i < size; i++) {
            this.array[i] = this.array[i+1];
        }
        size--;
        if (size > 0 && (array.length > 2 * size)) {
            this.array = resize(array, "reduce");
        }
        return true;
    }

    /**
     * Removes all elements from this list.
     *
     * @return {@code true} if the list was successfully cleared
     */
    @Override
    public boolean clear() {
            size = 0;
            this.array = (E[]) new Object[DEFAULT_CAPACITY];
            return true;
    }

    /**
     * Sorts the elements in this list into ascending order.
     */
    @Override
    public void sort() {
        if (size > 0) {
            if (array[0] instanceof Comparable) {
                Comparable<E>[] comparableArray = (Comparable<E>[]) new Comparable[size];
                System.arraycopy(array, 0, comparableArray, 0, size);

                // Sort the new array
                MyQuickSort.quickSort(comparableArray, 0, size - 1);

                // Copy the sorted elements back to the original array
                System.arraycopy(comparableArray, 0, array, 0, size);
            } else {
                throw new UnsupportedOperationException("Elements must be Comparable to use this sort method");
            }
        }
    }

    /**
     * Sorts the elements in this list according to the order induced by the specified comparator.
     *
     * @param comparator the comparator to determine the order of elements
     */
    @Override
    public void sort( Comparator<E> comparator) {
        if (size > 0) {
            MyQuickSort.quickSort(array, 0, size - 1, comparator);
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @return {@code true} if the element was successfully set
     */
    @Override
    public boolean set(int index, E item) {
        this.array[index] = item;
        return true;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of the internal array.
     *
     * @return the current capacity of the internal array
     */
    public int length() {
        return this.array.length;
    }

    /**
     * Checks for the presence of the following element.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Resizes the internal array.
     *
     * @param oldArray the old array
     * @param operation the resize operation ("increase" or "reduce")
     * @return the new resized array
     * @throws IllegalArgumentException if an invalid operation is specified
     */
    public E[] resize(E[] oldArray, String operation) {
        int len = oldArray.length;
        int newLen;
        if (operation.equals("increase")) {
            newLen = len * 2;
        } else if (operation.equals("reduce")) {
            newLen = Math.max(DEFAULT_CAPACITY, len / 2);
        } else {
            throw new IllegalArgumentException("Illegal operation");
        }

        try {
            E[] newArray = (E[]) new Object[newLen];
            System.arraycopy(oldArray, 0, newArray, 0, size);
            return newArray;
        }
        catch (ClassCastException ex){
            ex.getMessage();
        }
        return oldArray;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator for the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<>(array);
    }

}
