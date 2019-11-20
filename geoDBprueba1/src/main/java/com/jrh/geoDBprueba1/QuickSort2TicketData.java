package com.jrh.geoDBprueba1;
import java.util.List;

/* package com.baeldung.algorithms.quicksort; */

public class QuickSort2TicketData {

    public static void quickSort(List<_2TicketData> list, int begin, int end)
    {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(list, begin, partitionIndex-1);
            quickSort(list, partitionIndex+1, end);
        }
    }

    private static int partition(List<_2TicketData> list, int begin, int end)
    {
        _2TicketData pivot = list.get(end);
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;

                _2TicketData swapTemp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swapTemp);
            }
        }

        _2TicketData swapTemp = list.get(i+1);
        list.set(i+1, list.get(end));
        list.set(end, swapTemp);

        return i+1;
    }

}