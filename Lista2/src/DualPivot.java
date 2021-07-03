import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DualPivot {
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

    public DualPivot(String file, int[] array, int low, int high, int number, int k,String order) {
        this.file = file;
        this.array = array;
        this.low = low;
        this.high = high;
        this.number = number;
        this.k = k;
        this.order = order;
        startTime = System.nanoTime();
        sort(array,low,high);
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult();
    }

    // divide the array on the basis of pivot
    public int[] partition(int array[], int low, int high) {

        compares++;
        if(array[high] < array[low]) {
            if(order.equals("ascending")){
                swap(array,low,high);
                moves++;
            }
        } else {
            if(order.equals("descending")) {
                swap(array,low,high);
                moves++;
            }
        }
        // select last element as pivot
        int pivot1 = array[low];
        int pivot2 = array[high];

        int j = low + 1;
        int g = high - 1;
        int k = low + 1;
        int l = 0;
        int s = 0;

        compares++;
        while (k <= g) {
            compares++;
            if (s >= l) {
                compares++;
                if(order.equals("ascending")) {
                    if (array[k] < pivot1) {
                        //System.err.println("Compare " + array[k] +" < " + pivot1);
                        s++;
                        swap(array, j, k);
                        //System.err.println("Swap " + array[k] + " (pos:"+(k)+","+j+")");
                        moves++;
                        j++;
                        k++;
                    } else {
                        compares++;
                        if (array[k] < pivot2) {
                            //System.err.println("Compare " + array[k] +" >= " + pivot2);
                            k++;
                            l++;
                        } else {
                            swap(array, k, g);
                            g--;
                            s--;
                            moves++;
                        }
                    }
                } else {
                    if (array[k] > pivot1) {
                        s++;
                        swap(array, j, k);
                        //System.err.println("Swap " + array[k] + " (pos:"+(k)+","+j+")");
                        moves++;
                        j++;
                        k++;
                    } else {
                        compares++;
                        if (array[k] > pivot2) {
                            //System.err.println("Compare " + array[k] +" >= " + pivot2);
                            k++;
                            l++;
                        } else {
                            swap(array, k, g);
                            g--;
                            moves++;
                            s--;
                        }

                    }
                }
            } else {
                compares++;
                if(order.equals("ascending")) {
                    if (array[g] > pivot2) {
                        //System.err.println("Compare " + array[k] +" > " + pivot2);
                        //System.err.println("K " + k +" and J " + j);
                        g--;
                        l++;
                    } else {
                        compares++;
                        if (array[g] < pivot1) {
                            int temp = array[g];
                            array[g] = array[k];
                            array[k] = array[j];
                            array[j] = temp;
                            moves++;
                            j++;
                            s++;
                        } else {
                            swap(array, k, g);
                            l--;
                            moves++;
                        }
                        k++;
                    }
                } else {
                    if (array[g] < pivot2) {
                        //System.err.println("Compare " + array[k] +" > " + pivot2);
                        //System.err.println("K " + k +" and J " + j);
                        g--;
                        l++;
                    } else {
                        compares++;
                        if (array[g] > pivot1) {
                            int temp = array[g];
                            array[g] = array[k];
                            array[k] = array[j];
                            array[j] = temp;
                            moves++;
                            j++;
                            s++;
                        } else {
                            swap(array, k, g);
                            l--;
                            moves++;
                        }
                        k++;
                    }

                }
            }
        }
        j--;
        g++;
        swap(array, low, j);
        moves++;
        swap(array, high, g);
        moves++;
        return new int[] { j, g };
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int array[], int low, int high) {
        if (low < high) {
            // Select pivot position and put all the elements smaller
            // than pivot on the left and greater than pivot on right
            compares++;
            int[] temp = partition(array, low, high);

            int p1 = temp[0];
            int p2 = temp[1];
            // sort the elements on the left of the pivot
            sort(array, low, p1-1);
            sort(array, p1+1, p2-1);
            sort(array, p2 + 1, high);
        }
    }

    public void printResult() {
        if(file.equals("")) {
            System.out.println("For n  : " + number);
            System.out.println("In order : " + order);
            System.out.println("Execution time in nanoseconds  : " + timeElapsed);
            System.out.println("Execution time in milliseconds  : " + timeElapsed/(1000000.));
            System.out.println("Element"+ Arrays.toString(array));
            System.out.println("Compares "+compares);
            System.out.println("Moves "+moves);
        } else {
            try {
                if(k == 1 || k==10 || k==100 || k==1000) {
                    FileWriter myWriter = new FileWriter(file,true);
                    myWriter.write("For k = "+k+"\n");
                    myWriter.write("DualPivotQuicksort for n "+number+" operation\n");
                    myWriter.write("Execution time in nanoseconds  : " + timeElapsed+"\n");
                    myWriter.write("Execution time in milliseconds  : " + timeElapsed/(1000000.)+"\n");
//                //myWriter.write("Element"+ Arrays.toString(array)+"\n");
                    myWriter.write("Compares "+compares+"\n");
                    myWriter.write("Moves "+moves+"\n");
                    myWriter.write("\n");
                    myWriter.close();

                    myWriter = new FileWriter("statDual.txt",true);
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
