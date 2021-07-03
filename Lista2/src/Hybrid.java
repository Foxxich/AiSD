import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hybrid <T extends Comparable<T> & Serializable>{

    private int compares = 0;
    private int moves = 0;
    private int number = 0;
    private String order;
    private long startTime;
    private long timeElapsed;
    private String file;
    private int low;
    private int k;
    private int high;

    List<T> list;

    public Hybrid(List<T> collection, String order, int number, int k, String file) {
        this.list = new ArrayList<>(collection);
        this.order = order;
        this.number = number;
        this.k = k;
        this.file = file;
        if(k == 0) {
            printSimpleResult();
        }
        startTime = System.nanoTime();
        optimizedQuicksort(list,0,list.size()-1);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        if(k == 0) {
            System.out.println("________________________");
            printSimpleResult();
        } else {
            printResult();
        }
    }

    public void insertionSort(List<T> arr, int low, int n)
    {
        // Start from the second element (the element at index 0
        // is already sorted)
        for (int i = low + 1; i <= n; i++)
        {
            T value = arr.get(i);
            int j = i;

            // find index `j` within the sorted subset `arr[0…i-1]`
            // where element `arr[i]` belongs
            if(order.equals("ascending")) {
                while (j > low && arr.get(j - 1).compareTo(value) > 0) {
                    arr.set(j, arr.get(j - 1));
                    j--;
                    compares++;
                    moves++;
                }
            } else {
                while (j > low && arr.get(j - 1).compareTo(value) < 0) {
                    arr.set(j, arr.get(j - 1));
                    j--;
                    compares++;
                    moves++;
                }
        }

            // note that subarray `arr[j…i-1]` is shifted to
            // the right by one position, i.e., `arr[j+1…i]`
            arr.set(j,value);
            moves++;
        }
    }

    public int partition(List<T> a, int low, int high)
    {
        // Pick the rightmost element as a pivot from the array
        T pivot = a.get(high);

        // elements less than the pivot will be pushed to the left of `pIndex`
        // elements more than the pivot will be pushed to the right of `pIndex`
        // equal elements can go either way
        int pIndex = low;

        // each time we find an element less than or equal to the pivot,
        // `pIndex` is incremented, and that element would be placed
        // before the pivot.
        for (int i = low; i < high; i++)
        {
            compares++;
            if(order.equals("ascending")) {
                compares++;
                if (a.get(i).compareTo(pivot) <= 0) {
                    T temp = a.get(i);
                    a.set(i, a.get(pIndex));
                    a.set(pIndex, temp);
                    pIndex++;
                    moves++;
                }
            } else {
                compares++;
                if (a.get(i).compareTo(pivot) >= 0) {
                    T temp = a.get(i);
                    a.set(i, a.get(pIndex));
                    a.set(pIndex, temp);
                    pIndex++;
                    moves++;
                }
            }
        }

        // swap `pIndex` with pivot
        T temp = a.get(high);
        a.set(high,a.get(pIndex));
        a.set(pIndex,temp);
        moves++;
        // return `pIndex` (index of the pivot element)
        return pIndex;
    }

    public void optimizedQuicksort(List<T> A, int low, int high) {
        while (low < high) {
            compares++;
            // switch to insertion sort if the size is 10 or smaller
            if (A.size() <= 10) {
                insertionSort(A, low, high);
                break;
            } else {
                int pivot = partition(A, low, high);

                // tail call optimizations – recur on the smaller subarray
                if (pivot - low < high - pivot) {
                    optimizedQuicksort(A, low, pivot - 1);
                    low = pivot + 1;
                    moves++;
                } else {
                    optimizedQuicksort(A, pivot + 1, high);
                    high = pivot - 1;
                    moves++;
                }
            }
        }
    }

    private void printSimpleResult() {
        for (Serializable element : list) System.out.println(element.toString());
        System.out.println("For n  : " + number+" QuickSort");
        System.out.println("In order : " + order);
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds  : " + timeElapsed/(1000000.));
        System.out.println("Compares "+compares);
        System.out.println("Moves "+moves+"\n");
    }

    public void printResult() {
        if(file.equals("")) {
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
            System.out.println("Execution time in milliseconds  : " + timeElapsed/(1000000.));
            System.out.println("Compares "+compares);
            System.out.println("Moves "+moves);
        } else {
            if(k == 1 || k==10 || k==100 || k==1000) {
                try {
                    FileWriter myWriter = new FileWriter(file, true);
                    myWriter.write("Hybrid for n " + number + " operation\n");
                    myWriter.write("Execution time in nanoseconds  : " + timeElapsed + "\n");
                    myWriter.write("Execution time in milliseconds  : " + timeElapsed / (1000000.) + "\n");
//                //myWriter.write("Element"+ Arrays.toString(array)+"\n");
                    myWriter.write("Compares " + compares + "\n");
                    myWriter.write("Moves " + moves + "\n");
                    myWriter.write("\n");
                    myWriter.close();

                    myWriter = new FileWriter("statHybrid.txt", true);
                    myWriter.write(number + "     ");
                    myWriter.write(timeElapsed / (1000000.) + "     ");
                    myWriter.write(compares + "       ");
                    myWriter.write(moves + "      ");
                    myWriter.write("\n");
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
