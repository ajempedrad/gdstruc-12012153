package com.gdstruct.module1;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[10];

        numbers[0] = 35;
        numbers[1] = 69;
        numbers[2] = 1;
        numbers[3] = 10;
        numbers[4] = -50;
        numbers[5] = 328;
        numbers[6] = 63;
        numbers[7] = 58;
        numbers[8] = 26;
        numbers[9] = 13;

        System.out.println("Before sort: ");
        printArrayElements(numbers);

        //bubbleSort(numbers);
        selectionSortByLargest(numbers);
        //selectionSortBySmallest(numbers);

        System.out.println("\n\nAfter sort: ");
        printArrayElements(numbers);
    }

    private static void bubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i +1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    private static void selectionSortByLargest(int[] arr)
    {
        for (int lastSortedIndex = 0; lastSortedIndex < arr.length; lastSortedIndex++)
        {
            int largestIndex = lastSortedIndex;

            for (int i = lastSortedIndex; i < arr.length; i++)
            {
                if (arr[i] > arr[largestIndex])
                {
                    largestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[largestIndex];
            arr[largestIndex] = temp;
        }
    }

    private static void selectionSortBySmallest(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            int smallestIndex = 0;

            for (int i = 0; i <= lastSortedIndex; i++)
            {
                if(arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
    private static void printArrayElements(int[] arr)
    {
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}
