package org.example;

import java.util.Comparator;

/**
 * A simple generic array interface that provides basic operations for managing elements.
 * This interface supports adding, removing, sorting, and retrieving elements from the array.
 * <p>
 * It also extends the {@code Iterable<E>} interface, allowing the array elements to be
 * iterated over using an enhanced for loop or other iteration constructs.
 *
 * @param <E> the type of elements in this array
 */
public interface MySimpleArray<E> extends Iterable<E> {

    /**
     * Adds the specified element to the end of the array.
     *
     * @param item the element to be added
     * @return {@code true} if the element was added successfully, {@code false} otherwise
     */
    boolean add(E item);

    /**
     * Adds the specified element at the specified index in the array.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which the specified element is to be inserted
     * @param item  the element to be added
     * @return {@code true} if the element was added successfully, {@code false} otherwise
     */
    boolean add(int index, E item);

    /**
     * Returns the element at the specified position in the array.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     */
    E get(int index);

    /**
     * Removes the element at the specified position in the array.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @return {@code true} if the element was removed successfully, {@code false} otherwise
     */
    boolean remove(int index);

    /**
     * Removes all elements from the array. The array will be empty after this call.
     *
     * @return {@code true} if the array was successfully cleared, {@code false} otherwise
     */
    boolean clear();

    /**
     * Sorts the elements in the array according to their natural ordering.
     * All elements in the array must implement the {@link Comparable} interface.
     */
    void sort();

    /**
     * Sorts the elements in the array according to the order induced by the specified {@link Comparator}.
     *
     * @param comparator the comparator to determine the order of the array
     */
    void sort(Comparator<E> comparator);

    /**
     * Replaces the element at the specified position in the array with the specified element.
     *
     * @param index the index of the element to replace
     * @param item  the element to be stored at the specified position
     * @return {@code true} if the element was set successfully, {@code false} otherwise
     */
    boolean set(int index, E item);

    /**
     * Returns the number of elements in the array.
     *
     * @return the number of elements in the array
     */
    int size();

    /**
     * Returns {@code true} if the array contains no elements.
     *
     * @return {@code true} if the array is empty, {@code false} otherwise
     */
    boolean isEmpty();
}
