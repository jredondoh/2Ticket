package com.jrh.geoDBprueba1;
/* package com.baeldung.algorithms.quicksort; */

public class QuickSort {

    public static void quickSort(long arr[], int begin, int end)
    {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(long arr[], int begin, int end)
    {
        long pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (arr[j] <= pivot) {
                i++;

                long swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        long swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

}