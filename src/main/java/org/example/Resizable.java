package org.example;

/**
 *  Interface for resizing an array of elements of type E.
 *
 * @param <E> the type of elements in the array
 */
public interface Resizable<E> {
    /**
     * Resizes the provided array according to the specified operation.
     *
     * @param oldArray oldArray the original array to be resized
     * @param operation operation a string indicating the resize operation (e.g., "increase", "decrease")
     * @return a new array with the modified size
     */
    public E[] resize(E[] oldArray, String operation);
}
