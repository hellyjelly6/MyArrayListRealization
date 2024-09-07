package org.example;

import java.util.Comparator;

/**
 * Class implementing the quicksort algorithm for arrays.
 * <p>
 * It provides methods for sorting array elements using the quicksort algorithm.
 * It supports natural ordering via {@link Comparable} and custom ordering via {@link Comparator}.
 *
 * @param <E> the type of elements in the array
 */
public class MyQuickSort<E> {

    /**
     * Sorts an array using the quicksort algorithm.
     * <p>
     * This method sorts a portion of the array between left and right boundaries of array,
     * using the natural order of the elements.
     *
     * @param arr the array to be sorted
     * @param left the left boundary of the array portion to be sorted
     * @param right the right boundary of the array portion to be sorted
     * @param <E> the type of elements in the array
     * @return the sorted array
     */
    public static <E> E[] quickSort(Comparable<E>[] arr, int left, int right){
        if(left < right){
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
        return (E[]) arr;
    }

    /**
     * Partitions the original array.
     * <p>
     * The method selects the last element as the pivot and moves elements
     * with values greater than the pivot to the right of it, while elements with
     * smaller values are moved to the left part of the array using the natural order of the elements.
     *
     * @param arr the array to be partitioned
     * @param left the left boundary of the array portion to be partitioned
     * @param right the right boundary of the array portion to be partitioned
     * @param <E> the type of elements in the array
     * @return the index of the pivot element after partitioning
     */
    public static <E> int partition(Comparable<E>[] arr, int left, int right){

        Comparable pivot = arr[right];
        int i = left -1;
        for(int j = left; j< right; j++){
            if(arr[j].compareTo((E) pivot)<0){
                i++;
                Comparable temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
        }
        Comparable temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

    /**
     * Sorts an array using the quicksort algorithm and a given comparator.
     * <p>
     * This method sorts a portion of the array between left and right boundaries of array,
     * using the order defined by the provided comparator.
     *
     * @param arr the array to be sorted
     * @param left the left boundary of the array portion to be sorted
     * @param right the right boundary of the array portion to be sorted
     * @param comparator {@Code comparator} for determining the order of elements
     * @param <E> the type of elements in the array
     * @return the sorted array
     */
    public static <E> E[] quickSort(E[] arr, int left, int right, Comparator<E> comparator){
        if(left < right){
            int pivot = partition(arr, left, right, comparator);

            quickSort(arr, left, pivot-1, comparator);
            quickSort(arr, pivot+1, right, comparator);
        }
        return arr;
    }

    /**
     * Partitions the original array.
     * <p>
     * The method selects the last element as the pivot and moves elements
     * with values greater than the pivot to the right of it, while elements with
     * smaller values are moved to the left part of the array using the natural order of the elements.
     *
     * @param arr the array to be partitioned
     * @param left the left boundary of the array portion to be partitioned
     * @param right the right boundary of the array portion to be partitioned
     * @param comparator {@Code comparator} for determining the order of elements
     * @param <E> the type of elements in the array
     * @return the index of the pivot element after partitioning
     */
    public static <E> int partition(E[] arr, int left, int right, Comparator<E> comparator){

        E pivot = arr[right];
        int i = left -1;
        for(int j = left; j< right; j++){
            if(comparator.compare(arr[j], pivot)<0){
                i++;
                E temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
        }
        E temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

}
