import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class RandomSelect {


    private int compares = 0;
    private int moves = 0;
    private final String file = "statRS.txt";
    private long startTime;
    private long timeElapsed;
    private Integer[] array;
    private int low;
    private int high;
    private int k;
    private int result;
    private int selectedValue;
    private int n;
    private int m;
    private String listType;

    public RandomSelect(Integer[] array, int low, int high, int k, int m, String listType) throws IOException {
        this.array = array;
        this.low = low;
        this.high = high;
        this.k = k;
        this.m = m;
        this.listType = listType;
        n = array.length;
        int arr[] = new int[array.length];
        for(int i = 0; i < high; i++){
            arr[i] = Integer.parseInt(array[i].toString());
            //System.out.println("I"+i+" pos - "+array[i]);
            //System.out.println("I"+i+" pos - "+arr[i]);
        }
        startTime = System.nanoTime();
        result = randomSelect(arr, 0,arr.length - 1, k);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult(arr);
        if(m == 0) {
            for (int i = 0; i < high; i++) {
                if (arr[i] == result) {
                    System.out.print("[" + arr[i] + "] ");
                } else {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

    public long getTime() {
        return timeElapsed;
    }

    private void random(int arr[], int low, int high)
    {
        //moves++;
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
        //System.err.println("Swap"+pivot+" with "+high+" where" +arr[high]+"="+temp1);
    }

    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    private int partition(int arr[], int low, int high)
    {
        //System.err.println("Doing partition");
        // pivot is chosen randomly
        random(arr,low,high);
        int pivot = arr[high];

        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++)
        {
            compares++;
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot)
            {
                i++;
                moves++;
                //System.err.println("Swap"+i+" with "+j);
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        //System.err.println("Swap"+i+" with "+j);
        moves++;
        return i+1;
    }

    public int randomSelect(int array[], int p, int r, int i) {
        if (p == r) {
            //System.err.printf("return array[p] = (%d)\n", array[p]);
            selectedValue = array[p];
            return array[p];
        }
        Integer q = partition(array, p, r);
        Integer k = q - p + 1;      // pivot + all number less than pivot
        if (i == k) {
            //System.err.printf("[i == k], return array[q] = (%d)\n", array[q]);
            selectedValue = array[q];
            return array[q];
        } else if (i < k)
            return randomSelect(array, p, q - 1, i);
        else
            return randomSelect(array, q + 1, r, i - k);
    }

    private void printResult(int[] arr) throws IOException {
        FileWriter myWriter;
        if(listType.equals("randomNumbers")) {
            myWriter = new FileWriter("randomRS"+m+".txt", true);
        } else {
            myWriter = new FileWriter("permutationRS"+m+".txt", true);
        }
        myWriter.write(n+",");
        myWriter.write(+k+",");
        myWriter.write(timeElapsed / (1000000.) + ",");
        myWriter.write(compares + ",");
        myWriter.write(moves + ",");
        myWriter.write(m + "\n");
//        for(int i=0; i< high; i++){
//            if(arr[i] == result) {
//                myWriter.write("[" + arr[i] + "] ");
//            } else {
//                myWriter.write(arr[i] + " ");
//            }
//        }
        myWriter.write("\n");
        myWriter.close();
    }
}
