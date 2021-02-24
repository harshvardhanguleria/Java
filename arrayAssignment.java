import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class arrayAssignment {
    public ArrayList<Integer> arr = new ArrayList<>(
        Arrays.asList(1, 3, 5, 7, 0, 2, 4, 9, 8));
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 0, 2, 4, 9, 8, 6};
        int size = 10;
        arrayEvenOdd(array, size);
        System.out.println();
        arrayToArrayList(array, size);
        System.out.println(); 
        System.out.println("Second smallest element "+
            "in the array: "+ 
            secondSmallestElement(array, size)); 
        arrayListToArray(); 
        System.out.println();
        System.out.println(smallestDistance(array, size));
        System.out.println("Peak element: "+ 
            peakElement(array, size));
        bubbleSelectionSort();
    }

    public static void arrayEvenOdd(int[] array, int size) {
        int[] even = new int[10];
        int[] odd = new int[10];
        int count1 = 0, count2 = 0;
        System.out.print("The original array is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] +" ");
            if (array[i] % 2 == 0) 
                even[count1++] = array[i]; 
            else 
                odd[count2++] = array[i];
        }
        System.out.println();
        System.out.print("The even array is: ");
        for (int i = 0; i < count1; i++)
            System.out.print(even[i] +" ");
        System.out.print("The odd array is: ");
        for (int i = 0; i < count2; i++)
            System.out.print(odd[i] +" ");
    }

    public static int smallestDistance(int[] array, int size) {
        int smallest = Math.abs(array[0] - array[1]);
        int smallest1 = 0, x = 0, y = 0;
        for (int i = 1; i < size - 1; i++) {
            smallest1 = Math.abs(array[i] - array[i + 1]);
            if (smallest1 < smallest) {
                x = array[i];
                y = array[i + 1];
                smallest = smallest1;
            }
            else
                continue;
        }
        System.out.print(x +" and "+ y +" have the smallest"
            +" distance ");
        return smallest;
    }

    public static int secondSmallestElement(int[] array, 
        int size) {
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array[1];
    }

    public static void arrayToArrayList(int[] array, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) 
            list.add(array[i]);
        System.out.println("Array list is: "+ list);
    }

    public static void arrayListToArray() {
        arrayAssignment a = new arrayAssignment();
        int count = 0;
        int[] array = new int[a.arr.size()];
        for (int i : a.arr)
            array[count++] = i;
        System.out.println("Array List: "+ a.arr);
        System.out.println();
        System.out.print("Converted to Array: ");
        System.out.println(Arrays.toString(array));
    } 

    public static int peakElement(int[] array, int size) {
        int peak = -1, peak1 = -1, peak2 = -1;
        if (array[0] > array[1])
            peak1 = array[0];
        if (array[size - 1] > array[size - 2])
                peak2 = array[size - 1];
        for (int i = 1; i < size - 1; i++) {
            if (array[i] > array[i - 1] && 
                    array[i] > array[i + 1])
                peak = array[i];
        }
        if (peak > peak1 && peak > peak2)
            return peak;
        else if (peak1 > peak && peak1 > peak2)
            return peak1;
        else
            return peak2;
    }

    public static void bubbleSelectionSort() {
        arrayAssignment aa = new arrayAssignment();
        int temp = 0, size = aa.arr.size();
        ArrayList<Integer> dummy = new ArrayList<Integer>(size);
        dummy = aa.arr;
        System.out.println("Using bubble sort");
        for (int i = 0; i < size; i++) {
            System.out.println(dummy);
            for (int j = i; j < size - 1; j++) {
                if (dummy.get(j) > dummy.get(j + 1)) {
                    temp = dummy.get(j);
                    dummy.set(j, dummy.get(j + 1));
                    dummy.set(j + 1, temp);
                }
            }
        }
        System.out.println("The sorted list is: "+ dummy);
        System.out.println("Using Quick Sort");
        quickSort(size, 0, size - 1);
    }   
    
    public static void quickSort(int size, int start, int last) {
        arrayAssignment a = new arrayAssignment();
        int mid = 0;
        if (start < last) {
            mid = sortPartition(a, start, last, size);
            quickSort(size, start, mid - 1);
            quickSort(size, mid + 1, last);
        }
        System.out.println("The sorted list is: "+ a.arr);
    }

    public static int sortPartition(arrayAssignment a,
        int start, int last, int size) {
        int count = start - 1, temp = 0;
        int pivot = a.arr.get(last);
        for (int i = start; i < last; i++) {
            if (a.arr.get(i) <= pivot) {
                count ++;
                temp = a.arr.get(count);
                a.arr.set(count, a.arr.get(i));
                a.arr.set(i, temp);
            }
        }
        temp = a.arr.get(count + 1);
        a.arr.set(count, a.arr.get(last));
        a.arr.set(last, temp);
        return (count + 1);
    }
}