import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Select {

    private int compares = 0;
    private int moves = 0;
    private final String file = "statMM.txt";
    private long startTime;
    private long timeElapsed;
    private int low;
    private Integer[] array;
    private int high;
    private int k;
    private int m;
    private int result;
    private int n;
    private String listType;

    public Select(Integer[] array, int low, int high, int k, int m, String listType) throws IOException {
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
//            System.out.println("I"+i+" pos - "+arr[i]);
        }
        startTime = System.nanoTime();
        result = getK(arr, 0,arr.length-1, k--);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        //System.out.println("kth smallest in the given array is "+ result +"  where n is "+n+"  and k is"+(k+1));
        if(m == 0) {
            for (int i = 0; i < high; i++) {
                if (arr[i] == result) {
                    System.out.print("[" + arr[i] + "] ");
                } else {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        printResult(arr);
    }

    private int getK(int arr[], int low, int high, int k) {
        if (k > 0 && k <= high - low + 1) {
            // number of elements in array
            int n = high - low + 1;
            //System.err.println("Finding the median");
            int i, median[] = new int[(n + 25) / 25];//mod5

            for (i = 0; i < median.length - 1; i++) { //mod5
                median[i] = getMedian(Arrays.copyOfRange(arr, 25 * i + low, 25 * i + low + 24), 25);
                moves++;
            }

            if (n % 25 == 0) { //mod5
                median[i] = getMedian(Arrays.copyOfRange(arr, 25 * i + low, 25 * i + low + 24), 25);
                i++;
                moves++;
            } else { //mod5
                median[i] = getMedian(Arrays.copyOfRange(arr, 25 * i + low, 25 * i + low + (n % 25)), n % 25);
                i++;
                moves++;
            }

            int medOfMed = i == 1 ? median[i - 1]
                    : getK(median, 0, i - 1, i / 2);

            int partition = partitionPractise(arr, low, high, medOfMed);

            if (partition - low == k - 1) {
                return arr[partition];
            }

            if (partition - low > k - 1) {
                return getK(arr, low, partition - 1, k);
            }

            return getK(arr, partition + 1, high, k - (partition + 1) + low);
        }

        return -1;
    }

    private int getMedian(int arr[], int n) {
        Arrays.sort(arr);
        return arr[n / 2];
    }

    private void swap(int[] arr, int i, int index) {
        //System.err.println("Swap"+i+" with "+index);
        if (arr[i] == arr[index]) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        moves++;
    }

    private int partitionPractise(int[] arr, int low, int high, int pivot) {
        compares++;
        //System.err.println("Comparing in partition");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, high);
                break;
            }
        }
        int index = low - 1;
        int i = low;
        while (i < high) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, i, index);
            }
            i++;
        }
        index++;
        //System.err.println("Swap"+index+" with "+high);
        swap(arr, index, high);
        return index;
    }

    private void printResult(int[] arr) throws IOException {
        FileWriter myWriter;
        if(listType.equals("randomNumbers")) {
            myWriter = new FileWriter("randomS"+m+".txt", true);
        } else {
            myWriter = new FileWriter("permutationS"+m+".txt", true);
        }
        myWriter.write(n+",");
        myWriter.write(+k+",");
        myWriter.write(timeElapsed+ ",");
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