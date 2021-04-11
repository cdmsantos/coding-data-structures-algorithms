import java.io.*;
import java.util.*;

public class QuickSort2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        quickSort(array);

    }
        
    static void printArray(int[] ar,int start, int end) { 
        for(int i = start; i <= end;i++) { 
            System.out.print(ar[i]+" "); 
        } 
        System.out.println(""); 
    }
    
    static void copy(ArrayList<Integer> list, int ar[], int startIdx) {
        for (int num : list) {
            ar[startIdx++] = num;
        }
    }
    
    static int partition(int ar[], int minpos, int maxpos) {
        int p = ar[minpos];
        ArrayList<Integer> leftlist = new ArrayList<Integer>();
        ArrayList<Integer> rightlist = new ArrayList<Integer>();

        for (int i = minpos + 1; i <= maxpos; i++) {
            if (ar[i] > p)
                rightlist.add(ar[i]);
            else
                leftlist.add(ar[i]);
        }
        copy(leftlist, ar, minpos);
        int ppos = leftlist.size() + minpos;
        ar[ppos] = p;
        copy(rightlist, ar, ppos + 1);

        return minpos + leftlist.size();
    }

    static void quickSort(int ar[], int minpos, int maxpos) {
        if (minpos >= maxpos)
            return;

        int pos = partition(ar, minpos, maxpos);

        quickSort(ar, minpos, pos - 1);
        quickSort(ar, pos + 1, maxpos);

        printArray(ar, minpos, maxpos);
    }

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

}
