import java.io.*;
import java.util.Arrays;

public class QuicksortMedian {

    private int[] Array;
    private long[] data;
    private int len;
    private int numSwaps;
    private int numComps;
    private long first_ns, last_ns, time_ns;
    private float time_ms;
    private int kOperations;
    private int number;

    public QuicksortMedian(int[] Array, int kOperations, int number) throws IOException {
        this.Array = Array;
        this.kOperations = kOperations;
        this.number = number;
        numSwaps = 0;
        numComps = 0;
        data = new long[Array.length];
        len = 0;
        int n;
        // convert and fill array
        for (int j : Array) {
            n = j;
            insert(n);
        }
        //arr.display();  // display unsorted numbers (original array)
        first_ns = System.nanoTime();
        quickSort();
        last_ns = System.nanoTime();
        //arr.display();  // display sorted numbers (final sorted array)
        time_ns = last_ns - first_ns;
        time_ms = ((float) time_ns / 1000000);
        //arr.display(); // display sorted numbers (original array)
        printResult();
    }

    // init (helper function)
    public void quickSort() {
        recursiveQuicksort(0, len - 1);
    }

    public void recursiveQuicksort(int left, int right) {
        int size = right - left + 1;
        // if range is larger than three use quicksort
        if (size >= 3) {
            long median = medianOf3(left, right);    // determine partition
            int partition = partitionIterator(left, right, median);  // create partition
            recursiveQuicksort(left, partition - 1);    // sort left partition
            recursiveQuicksort(partition + 1, right);   // sort right partition
        }
        else {
            simpleSort(left, right);
        }
    }

    //medianOf3 used to determine the location of
    public long medianOf3(int left, int right) {
        //System.err.println("Getting the median");
        int center = (left + right) / 2;
        numComps++;
        if (data[left] > data[center]) {
            swap(left, center);
            //System.err.println("Swap "+left+" with "+center);
        }
        numComps++;
        if (data[left] > data[right]) {
            swap(left, right);
            //System.err.println("Swap "+left+" with "+right);
        }
        numComps++;
        if (data[center] > data[right]) {
            swap(center, right);
            //System.err.println("Swap "+center+" with "+right);
        }
        swap(center, right - 1);    // move the pivot to right
        //System.err.println("Swap "+center+" with "+(right-1));
        return data[right - 1];     // return pointer to location of median
    }

    //partitionIterator controls partition flow
    public int partitionIterator(int left, int right, long pivot) {
        int leftIndex = left; // right index of first element
        int rightIndex = right - 1; // left of pivot index

        while (true) {
            numComps++;
            while (data[++leftIndex] < pivot){
                numComps++;
                numSwaps++;
                //System.err.println("Compare leftIndex"+leftIndex +" with pivot"+pivot);
            }
            while (data[--rightIndex] > pivot){
                numComps++;
                numSwaps++;
                //System.err.println("Compare rightIndex"+rightIndex+" with pivot"+pivot);
            }
            if (leftIndex >= rightIndex) { // pointers crossed: break
                //System.err.println("Compare leftIndex "+leftIndex +" with rightIndex "+rightIndex);
                break;
            }
            else {
                swap(leftIndex, rightIndex); // pointers never crossed: swap elements
            }
        }
        swap(leftIndex, right - 1); // restore pivot
        //System.err.println("Swap "+leftIndex+" with "+(right-1));
        return leftIndex; // return pivot location
    }

    public void simpleSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return; // don't bother
        if (size == 2) {
            numComps++;
            //System.err.println("Compare size "+size +" with 2 ");
            if (data[left] > data[right]) {
                swap(left, right);
                //System.err.println("Swap left"+left+" with right"+right);
            }
            return;
        } else {
            numComps++;
            if (data[left] > data[right - 1]) {
                swap(left, right - 1);
                //System.err.println("Swap left"+left+" with (right-1)"+(right-1));
            }
            if (data[left] > data[right]) {
                swap(left, right);
                //System.err.println("Swap left"+left+" with right"+right);
            }
            if (data[right - 1] > data[right]) {
                swap(right - 1, right);
                //System.err.println("Swap (right-1)"+(right-1)+" with right"+right);
            }
        }
    }

    // swap indexes [ints] of two variables/arrays
    public void swap(int index1, int index2) {
        long temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
        numSwaps++;
    }

    public void insert(long value) {
        data[len] = value;
        len++;
    }

    // display array elements
    public void display() {
        System.out.print("Data: ");
        for (int j = 0; j < len; j++)
            System.out.print(data[j] + " ");
        System.out.println("");
    }

    private void printResult() throws IOException {
        if(kOperations == 1 || kOperations == 10 || kOperations == 100) {
            FileWriter myWriter;
            myWriter = new FileWriter("medianQS" + kOperations + ".txt", true);
            myWriter.write(Array.length + "    ");
            myWriter.write(time_ms + "     ");
            myWriter.write(numComps + "       ");
            myWriter.write(numSwaps + "      ");
            myWriter.write("\n");
            myWriter.close();
        }
    }
}
