import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {
    private int compares = 0;
    private int moves = 0;
    private int number = 0;
    private String order;
    private long startTime;
    private long timeElapsed;
    private String file;
    private int array[];
    private int low;
    private int high;
    private int k;

    public QuickSort(int[] array, int low, int high,String order, String file, int number, int k) {
        this.array = array;
        this.low = low;
        this.high = high;
        this.order = order;
        this.file = file;
        this.number = number;
        this.k = k;
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
            // compare all elements with pivot
            // swap the element greater than pivot
            // with element smaller than pivot
            // to sort in descending order
            // if (array[j] >= pivot)
            if(order.equals("ascending")){
                compares++;
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
                compares++;
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
            compares++;
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
        if(file.equals("")) {
            System.out.println("For n  : " + number+" QuickSort");
            System.out.println("In order : " + order);
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
            System.out.println("Execution time in milliseconds  : " + timeElapsed/(1000000.));
            System.out.println("Element"+ Arrays.toString(array));
            System.out.println("Compares "+compares);
            System.out.println("Moves "+moves+"\n");
        } else {
            try {
                if(k == 1 || k==10 || k==100 || k==1000) {
                    FileWriter myWriter = new FileWriter(file, true);
                    myWriter.write("For k = "+k+"\n");
                    myWriter.write("Quicksort for n " + number + " operation " + order + "\n");
                    myWriter.write("Execution time in nanoseconds  : " + timeElapsed + "\n");
                    myWriter.write("Execution time in milliseconds  : " + timeElapsed / (1000000.) + "\n");
//                //myWriter.write("Element"+ Arrays.toString(array)+"\n");
                    myWriter.write("Compares " + compares + "\n");
                    myWriter.write("Moves " + moves + "\n");
                    myWriter.write("\n");
                    myWriter.close();

                    myWriter = new FileWriter("statQuick.txt", true);
                    myWriter.write(number + "     ");
                    myWriter.write(timeElapsed / (1000000.) + "     ");
                    myWriter.write(compares + "       ");
                    myWriter.write(moves + "      ");
                    myWriter.write("\n");
                    myWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
