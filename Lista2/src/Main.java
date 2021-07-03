import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        int quantityNumbers = 0;
        int kOperations = 0;
        String orderType = null;

        if(args[0].equals("--type")) {

            Scanner scanner;
            String number;

            int myArray[] = new int[0];

            if(args[1].equals("hybrid")) {
                // java.lang.String
                // java.lang.Integer
                orderType = getOrder(args[3]);
                String path = args[4];
                int size = Integer.parseInt(args[5]);
                Class chosenClass = getClassFromUser(path,size);
                List list = getList(path,chosenClass);
                hybridSort(chosenClass, list,orderType,size,0,"");
            } else {
                scanner = new Scanner(System.in);
                number = scanner.nextLine();
                quantityNumbers = Integer.parseInt(number);
                myArray = new int[quantityNumbers];
                for(int i=0; i<quantityNumbers; i++ ) {
                    myArray[i] = scanner.nextInt();
                }
            }

            orderType = getOrder(args[3]);

            switch (args[1]) {
                case "insert":
                    InsertionSort insertionSort = new InsertionSort(myArray,orderType,"",quantityNumbers,0);
                    break;
                case "merge":
                    MergeSort mergeSort = new MergeSort(myArray,0,quantityNumbers-1,orderType,"",quantityNumbers,0);
                    break;
                case "quick":
                    QuickSort quickSort = new QuickSort(myArray,0,quantityNumbers-1,orderType,"",quantityNumbers,0);
                    break;
                case "dualpivot":
                    DualPivot dualPivot = new DualPivot("",myArray,0,quantityNumbers-1,quantityNumbers,0,orderType);
                    break;
                case "hybrid":
                    break;
            }
        } else if(args[0].equals("--stat")) {
            kOperations = Integer.parseInt(args[2]);
                for(int j=1;j<=kOperations;j++){
                    for(int n=100;n<=10000;n+=100){
                        int myArray1[] = new int[n];
                        int myArray2[] = new int[n];
                        int myArray3[] = new int[n];
                        int myArray4[] = new int[n];
                        for(int i=0;i<n;i++) {
                            myArray1[i] = getRandomIntBetweenRange(0,100000);
                            myArray2[i] = myArray1[i];
                            myArray3[i] = myArray1[i];
                            myArray4[i] = myArray1[i];
                        }
//                        DualPivot dualPivot = new DualPivot(args[1].toString(),myArray4,0,n-1,n,j,"descending");
//                    QuickSort quickSortDesc = new QuickSort(myArray1,0,n-1,"descending",args[1].toString(),n,j);
//                    InsertionSort insertionSortDesc = new InsertionSort(myArray2,"descending",args[1].toString(),n,j);
//                    MergeSort mergeSortDesc = new MergeSort(myArray3,0,n-1,"descending",args[1].toString(),n,j);
                        Class chosenClass = knownClassUser("hybridTestFile.txt",n);
                        List list = getList("hybridTestFile.txt",chosenClass);
                        hybridSort(chosenClass, list,"descending",n,j,args[1].toString());
                        File myObj = new File("hybridTestFile.txt");
                        myObj.delete();
                }
            }
        }
    }

    private static Class getClassFromUser(String path, int size) throws ClassNotFoundException {
        System.out.println("Give the name of object:");
        Scanner classScan = new Scanner(System.in);
        String classType = classScan.nextLine();
        if(classType.equals("java.lang.Integer")){
            createIntFile(path,size);
        } else {
            createTestFile(path,size);
        }
        return Class.forName(classType);
    }

    private static Class knownClassUser(String path, int size) throws ClassNotFoundException {
        String classType = "java.lang.Integer";
        if(classType.equals("java.lang.Integer")){
            createIntFile(path,size);
        } else {
            createTestFile(path,size);
        }
        return Class.forName(classType);
    }

    private static <T extends Comparable<T> & Serializable> void hybridSort(Class<T> type, List<T> list, String order, int n, int k, String filePath) {
        Hybrid<T> hybrid = new Hybrid<>(list,order,n,k,filePath);
    }

    private static <T> List<T> getList(String fileName,Class<T> type) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            List<T> list = (List<T>) objectInputStream.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createTestFile(String fileName, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = createRandomWord(6);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream((fileOutputStream))) {
            objectOutputStream.writeObject(List.of(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createIntFile(String fileName,int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomIntBetweenRange(0,100000);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream((fileOutputStream))) {
            objectOutputStream.writeObject(List.of(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getOrder(String path) {
        String orderType = "";
        switch (path.replace("\"", "")) {
            case ">=":
                orderType = "descending";
                break;
            case "<=":
                orderType = "ascending";
                break;
            case "":
                break;
        }
        return orderType;
    }

    public static int getRandomIntBetweenRange(double min, double max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }

    public static String createRandomWord(int len) {
        String name = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }

//    public void test(List<String> array) {
//
//    }
//
//    public void test(String word) {
//
//    }
//
//    public void test(Integer num) {
//
//    }
//
//    public void test(List<Integer> arrayList) {
//
//    }
}
