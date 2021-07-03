import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {
    private int compares = 0;
    private int moves = 0;
    private int number;
    private String order="ascending";
    private long startTime;
    private long timeElapsed;
    private long endTime;
    private String file;
    private int array[];
    private int low;
    private int high;
    private int k;

    public QuickSort(int[] array, int k, int number) {
        this.array = array;
        this.k = k;
        this.number = number;
        low = 0;
        high = array.length - 1;
        startTime = System.nanoTime();
        sort(array,low,high);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult();
    }

    // divide the array on the basis of pivot
    public int partition(int array[], int low, int high) {
        // select last element as pivot
        int pivot = array[high];

        // initialize the second pointer
        int i = (low - 1);
        // Put the elements smaller than pivot on the left and
        // greater than pivot on the right of pivot

        for (int j = low; j < high; j++) {
            compares++;
            if(order.equals("ascending")){
                //compares++;
                //System.err.println("Compare " + array[j] +" <= " + pivot);
                if (array[j] <= pivot) {
                    // increase the second pointer if
                    // smaller element is swapped with greater
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    moves++;
                    //System.err.println("Swap " + array[i] + " with " + array[j]+"(pos:"+i+","+j+")");
                }
            } else {
                //compares++;
                //System.err.println("Compare " + array[j] +" >= " + pivot);

                if (array[j] >= pivot) {
                    // increase the second pointer if
                    // smaller element is swapped with greater
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    moves++;
                    //System.err.println("Swap " + array[i] + " with " + array[j]+"(pos:"+i+","+j+")");
                }
            }
        }
        // put pivot in position
        // so that element on left are smaller
        // element on right are greater than pivot
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        moves++;//swapping array[i+1] with array[high]
        //System.err.println("Swap " + array[i+1] + " with " + array[high]+"(pos:"+(i+1)+","+high+")");
        return (i + 1);
    }

    public void sort(int array[], int low, int high) {
        if (low < high) {
            // Select pivot position and put all the elements smaller
            // than pivot on the left and greater than pivot on right
            int pi = partition(array, low, high);

            // sort the elements on the left of the pivot
            sort(array, low, pi - 1);

            // sort the elements on the right of pivot
            sort(array, pi + 1, high);
        }
    }

    public void printResult() {
        if(k == 1 || k == 10 || k == 100) {
            try {
                FileWriter myWriter;
                myWriter = new FileWriter("QS" + k + ".txt", true);
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
