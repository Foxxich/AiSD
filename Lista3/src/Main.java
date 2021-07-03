import java.io.*;
import java.util.*;

public class Main {

    private static Scanner scanner;
    private static int result;
    static ArrayList<Integer> resultList = new ArrayList<Integer>();
    private static long time;
    private static long time2;
    static ArrayList<Long> timeList = new ArrayList<Long>();
    static ArrayList<Long> timeList2 = new ArrayList<Long>();
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        int number;
        int position;
        int quantity = 0;
        int mOperations = 0;

        if (args[0].equals("selection")) {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            position = scanner.nextInt();
            switch (args[1]) {
                case "-r":
                    generateRandom(number,position,0);
                    break;
                case "-p":
                    generatePermutation(number,position,0);
                    break;
                case "-binary":
                    openWithBS(number,position,true,1);
                    break;
            }
        } else if(args[0].equals("auto")) {
            int m = 10;
            for (int j = 100; j <= 10000; j+=100) {
                for (int i = 1; i <= m; i++) {
                    //int k = getRandomInt(j - j/4,j);
                    int k = getRandomInt(j - j/4,j);
                    generateRandom(j,k,i);
                    generatePermutation(j,k,i);
                }
                timeList.add(time);
                resultList.add(result);
                timeList2.add(time2);
                time = 0;
                result = 0;
                time2 = 0;
            }
//            Double averageTime = timeList.stream().mapToLong(val -> val).average().orElse(0.0);
//            int sumResult = resultList.stream().mapToInt(val -> val).sum();
//            Double averageTime2 = timeList2.stream().mapToLong(val -> val).average().orElse(0.0);
//            System.out.println("AVG time Select "+averageTime);
//            System.out.println("SUM result "+sumResult);
//            System.out.println("AVG time RSelect "+averageTime2);
        } else if(args[0].equals("bs")) {
            int floor = 10;
            int limit = 100000;
            for (int j = 1000; j <= 100000; j += 1000) {
//                FileWriter myWriter = new FileWriter("statBS.txt", true);
//                myWriter.write( "["+j+"]\n");
                for(int i = 1; i<= 50; i++) {
                    int average = (j / 2) - getRandomInt(1, j/10);
//                    int k = getRandomInt(1, j);
//                    if(k%2 == 0) {
//                        k++;
//                    }
                    //limit = getRandomInt(j/2 + j/3 ,j - j/4);
                    openWithBS(j, average, false,i);
                }
//                myWriter.write( "("+result+")\n");
//                myWriter.close();
//                resultList.add(result);
//                timeList.add(time);
//                result = 0;
//                time = 0;
            }
//            Double averageResult = resultList.stream().mapToInt(val -> val).average().orElse(0.0);
//            Double averageTime = timeList.stream().mapToLong(val -> val).average().orElse(0.0);
//            System.out.println("AVG result"+averageResult+"    AVG time"+averageTime);
        } else if(args[0].equals("mqs")) {
            medianQuickSort();
        }
    }

    private static void generateRandom(int n, int k, int m) throws IOException {
        Integer[] array1 = new Integer[n];
        Integer[] array2 = new Integer[n];
        for(int i = 0; i < n; i++){
            array1[i] = getRandomInt(0,1000);
            array2[i] = array1[i];
        }
        Select select = new Select(array1, 0, array1.length, k,m,"randomNumbers");
        //RandomSelect randomSelect = new RandomSelect(array2, 0, array2.length, k,m,"randomNumbers");
//        Test test = new Test(array1,k);
//        time = test.getTime() + time;
//        result = test.getCompares() + result;
//        time2 = randomSelect.getTime() + time2;
    }

    private static int getRandomInt(double min, double max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }

    private static void generatePermutation(int n, int k, int m) throws IOException {
        Integer[] array1 = new Integer[n];
        Integer[] array2 = new Integer[n];
        int j = 1;
        for(int i = 0; i < n; i++){
            array1[i] = j;
            array2[i] = j;
            j++;
        }

        List <Integer> list1 = Arrays.asList(array1);
        Collections.shuffle(list1);
        array1 = list1.toArray(new Integer[0]);

        List <Integer> list2 = Arrays.asList(array2);
        Collections.shuffle(list2);
        array2 = list2.toArray(new Integer[0]);

        Select select = new Select(array1, 0, array1.length, k, m,"permutation");
        RandomSelect randomSelect = new RandomSelect(array2, 0, array2.length, k, m,"permutation");
    }

    private static void openWithBS(int size, int k, boolean flag, int m) throws IOException {
        int[] myArray = new int[size];
        if(!flag) {
            for(int i=0; i<size; i++ ) {
                myArray[i] = i;
            }
        } else {
            for(int i=0; i<size; i++) {
                myArray[i] = scanner.nextInt();
            }
        }
        BinarySearch binarySearch = new BinarySearch(myArray, 0, myArray.length-1, k, flag, m);
//        result = binarySearch.getCompares() + result;
//        time = binarySearch.getTime() + time;
    }

    private static void medianQuickSort() throws IOException {
        int kOperations = 100;
        for (int i = 1; i <= kOperations; i++) {
            for (int n = 100; n <= 10000; n+=100) {
                int[] myArray1 = new int[n];
                int[] myArray2 = new int[n];
                for(int j = 1; j<n; j++) {
                    myArray2[j] = j;//getRandomInt(1,10000);
                    myArray1[j] = myArray2[j];
                }
                QuickSort quickSort = new QuickSort(myArray2, i, n);
                QuicksortMedian quicksortMedian = new QuicksortMedian(myArray1,i, n);
                DualPivot dualPivot = new DualPivot(myArray1,0,myArray1.length-1,i);
            }
        }
    }
}
