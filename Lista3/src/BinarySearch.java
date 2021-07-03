import java.io.FileWriter;
import java.io.IOException;

public class BinarySearch {

    private int compares = 0;
    private int moves = 0;
    private final String file = "statBS.txt";
    private long startTime;
    private long timeElapsed;
    private int low;
    private int[] arr;
    private int high;
    private int x;
    private boolean saveAs;
    private int m;

    public BinarySearch(int[] arr, int low, int high, int x, boolean saveAs, int m) throws IOException {
        this.low = low;
        this.arr = arr;
        this.high = high;
        this.x = x;
        this.saveAs = saveAs;
        this.m = m;
        startTime = System.nanoTime();
        int result = binarySearchRecursive(arr, 0, arr.length-1, x);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult(result);
    }

    public int getCompares() {
        return compares;
    }

    public long getTime() {
        return timeElapsed;
    }

    private int binarySearchRecursive(int[] a, int lo, int hi, int key) {
        compares++;
        if (hi < lo) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRecursive(a, lo, mid - 1, key);
        } else {
            return binarySearchRecursive(a, mid + 1, hi, key);
        }

    }

    private void printResult(int result) throws IOException {
        FileWriter myWriter;
        myWriter = new FileWriter("BS"+m+".txt", true);
        myWriter.write(arr.length+","+x+",");
        myWriter.write(timeElapsed + ",");
        myWriter.write(compares + ",");
        if (result == -1) {
            //System.out.println("0");
            myWriter.write("0");
        } else {
            //System.out.println("1");
            myWriter.write("1");
        }
        myWriter.write("\n");
        myWriter.close();
    }
}
