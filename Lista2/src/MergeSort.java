import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
    private int compares = 0;
    private int moves = 0;
    private int number = 0;
    private String order;
    private long startTime;
    private String file;
    private long timeElapsed;
    private int array[];
    private int left;//low
    private int right;//high
    private int k;

    public MergeSort(int[] array, int left, int right, String order, String file, int number, int k) {
        this.array = array;
        this.left = left;
        this.right = right;
        this.order = order;
        this.file = file;
        this.number = number;
        this.k = k;
        startTime = System.nanoTime();
        mergeSort(array,left,right);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult();
    }

    // Merge two sub arrays L and M into array
    void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        // fill the left and right array
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
            moves++;
          //  System.err.println("Move " + array[p+i] + " to position " + i +" in L");
        }
        for (int j = 0; j < n2; j++){
            M[j] = array[q + 1 + j];
            moves++;
           // System.err.println("Move " + array[q+1+j] + " to position " + j +" in M");
        }

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // for sorting in descending
        // use if(L[i] >= <[j])

        while (i < n1 && j < n2) {
            if(order.equals("ascending")) {
             //   System.err.println("Compare " + L[i] + " <= " + M[j]);
                if (L[i] <= M[j]) {
                    array[k] = L[i];
                    compares++;
                   // System.err.println("Move "+L[i] + " to position " + k);
                    moves++;
                    i++;
                } else {
                    array[k] = M[j];
                    compares++;
                    //System.err.println("Move " + M[j] + " to position " + k);
                    moves++;
                    j++;
                }
            } else {
                //("Compare " + L[i] + " >= " + M[j]);
                if (L[i] >= M[j]) {
                    array[k] = L[i];
                    compares++;
                   // System.err.println("Move " + L[i] + " to position " + k);
                    moves++;
                    i++;
                } else {
                    array[k] = M[j];
                    compares++;
                   // System.err.println("Move " + M[j] + " to position " + k);
                    moves++;
                    j++;
                }
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            array[k] = L[i];
            compares++;
           // System.err.println("Compare " + i+" and " + n1);
            moves++;
           // System.err.println("Move " + L[i] + " to position " + k);
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            compares++;
           // System.err.println("Compare " + j+" and " + n2);
            moves++;
            //System.err.println("Move " + M[j] + " to position " + k);
            j++;
            k++;
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    void mergeSort(int array[], int left, int right) {
        if (left < right) {

            // m is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;

            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }

    public void printResult() {
        if(file.equals("")) {
            System.out.println("For n  : " + number+" MergeSort");
            System.out.println("In order : " + order);
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
            System.out.println("Execution time in milliseconds  : " + timeElapsed/(1000000.));
            System.out.println("Element"+ Arrays.toString(array));
            System.out.println("Compares "+compares);
            System.out.println("Moves "+moves+"\n");
        } else {
            try {
                if(k == 1 || k==10 || k==100 || k==1000) {
                    FileWriter myWriter = new FileWriter(file,true);
                    myWriter.write("For k = "+k+"\n");
                    myWriter.write("Mergesort for n "+number+" operation "+order+"\n");
                    myWriter.write("Execution time in nanoseconds  : " + timeElapsed+"\n");
                    myWriter.write("Execution time in milliseconds  : " + timeElapsed/(1000000.)+"\n");
                    //myWriter.write("Element"+ Arrays.toString(array)+"\n");
                    myWriter.write("Compares "+compares+"\n");
                    myWriter.write("Moves "+moves+"\n");
                    myWriter.write("\n");
                    myWriter.close();

                    myWriter = new FileWriter("statMerge.txt",true);
                    myWriter.write(number+"     ");
                    myWriter.write(timeElapsed/(1000000.)+"     ");
                    myWriter.write(compares+"       ");
                    myWriter.write(moves+"      ");
                    myWriter.write("\n");
                    myWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
