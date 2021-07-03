import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class InsertionSort {

    private int compares = 0;
    private int moves = 0;
    private int array[];
    private int number = 0;
    private String order;
    private String file;
    private long startTime;
    private long timeElapsed;
    private int k;

    public InsertionSort(int[] array, String order, String file, int number, int k) {
        this.array = array;
        this.order = order;
        this.file = file;
        this.number = number;
        this.k = k;
        startTime = System.nanoTime();
        sort();
        long endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        printResult();
    }

    public void sort() {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            //System.out.println("Moved " +key+" to "+array[step]);
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            if(order.equals("ascending")) {
                while(true) {
                    if(j >= 0) {
                       // System.err.println("Key " + key + " < " + array[j]);
                        compares++;
                        if ((key < array[j])) {
                            array[j + 1] = array[j];
                           //System.err.println("Move " + array[j] + " to position" +(j+1));
                            --j;
                            moves++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                while (true) {
                    if(j >= 0) {
                       //System.err.println("Key " + key + " < " + array[j]);
                        compares++;
                        if (key > array[j]) {
                            array[j + 1] = array[j];
                            //System.err.println("Move " + array[j] + " to position" + (j+1));
                            --j;
                            moves++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
           //System.err.println("Move " +key+" to position "+ (j+1));
            moves++;
        }
    }

    public void printResult() {
        if(file.equals("")) {
            System.out.println("For n  : " + number+" InsertionSort");
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
                    myWriter.write("InsertionSort for n " + number + " operation " + order + "\n");
                    myWriter.write("Execution time in nanoseconds  : " + timeElapsed + "\n");
                    myWriter.write("Execution time in milliseconds  : " + timeElapsed / (1000000.) + "\n");
                    //myWriter.write("Element"+ Arrays.toString(array)+"\n");
                    myWriter.write("Compares " + compares + "\n");
                    myWriter.write("Moves " + moves + "\n");
                    myWriter.write("\n");
                    myWriter.close();

                    myWriter = new FileWriter("statInsert.txt", true);
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
