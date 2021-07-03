import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static long minTime = 0L;
    static long sucTime = 0L;
    static long maxTime = 0L;
    static long searchTime = 0L;
    static int counterSuc = 0;
    static int counterMin = 0;
    static int counterMax = 0;
    static int counterSearch = 0;
    static String fileName;
    public static void main(String[] args) throws IOException {
        long startTimeProgram = System.nanoTime();
        int number;
        boolean scanElements;
        String operation;
        String data = "";
        Scanner scanner;
        Tree tree = null;
        //start counting
        if (args[0].equals("--type")) {
            fileName = args[2];
            if(!args[1].equals("cmd")) {
                scanner = new Scanner(System.in);
                number = scanner.nextInt();
                switch (args[1]) {
                    case "bst" -> tree = new BinarySearchTree();
                    case "rbt" -> tree = new RedBlackTree();
                    case "splay" -> tree = new TreeSplay();
                }
                for (int i = 0; i < number; i++) {
                    operation = scanner.next();
                    scanElements = checkOperation(operation);
                    if (scanElements) {
                        data = scanner.next();
                    }
                    switch (args[1]) {
                        case "bst", "rbt", "splay" -> treeBuild(tree, operation, data);
                    }
                    data = "";
                }
            } else {
                //System.out.println("Reading from file");
                List<String[]> argsList = readOperationType(fileName);
                //System.out.println("List "+argsList.toString());
                Iterator<String[]> iterator = argsList.iterator();
                String[] first = iterator.next();
                switch (first[0]) {
                    case "bst" -> tree = new BinarySearchTree();
                    case "rbt" -> tree = new RedBlackTree();
                    case "splay" -> tree = new TreeSplay();
                }
                while(iterator.hasNext()) {
                    String[] next = iterator.next();
                    operation = next[0];
                    scanElements = checkOperation(operation);
                    if (scanElements) {
                        data = next[1];
                    }
                    switch (first[0]) {
                        case "bst", "rbt", "splay" -> treeBuild(tree, operation, data);
                    }
                    data = "";
                }
            }
        }
        long endTimeProgram = System.nanoTime();
        long timeElapsedProgram = endTimeProgram - startTimeProgram;
//        System.err.println("Total time "+(timeElapsedProgram));
//        System.err.println("Inserts "+tree.counterInsert);
//        System.err.println("Delete  "+tree.counterDelete);
//        System.err.println("Inorder  "+tree.counterInorder);
//        System.err.println("Find  "+counterSearch);
//        System.err.println("Max  "+counterMax);
//        System.err.println("Min  "+counterMin);
//        System.err.println("Successor  "+counterSuc);
//        System.err.println("Max number of elements "+tree.maxNumberOfElements);
//        System.err.println("Final number of elements "+tree.currentNumberOfElements);
//        System.err.println("Insert time "+(tree.insertTime/tree.counterInsert));
//        System.err.println("Delete time "+(tree.deleteTime/tree.counterDelete));
//        System.err.println("Inorder time "+(tree.inorderTime/tree.counterInorder));
//        System.err.println("Find time "+(searchTime/counterSearch));
//        System.err.println("Max time "+(maxTime/counterMax));
//        System.err.println("Min time "+(minTime/counterMin));
//        System.err.println("Successor time "+(sucTime/counterSuc));
//        System.err.println("Total compares Insert "+tree.comparesInsert);
//        System.err.println("Total compares Delete "+tree.comparesDelete);
//        System.err.println("Total compares Find "+tree.comparesSearch);
//        System.err.println("Total compares Max "+tree.comparesMax);
//        System.err.println("Total compares Min "+tree.comparesMin);
//        System.err.println("Total compares Successor "+tree.comparesSuc);
    }

    private static boolean checkOperation(String operationType) {
        return operationType.equals("insert") ||
                operationType.equals("delete") ||
                operationType.equals("find") ||
                operationType.equals("load") ||
                operationType.equals("successor");
    }

    private static void treeBuild(Tree tree, String operationType, String element) throws IOException {
        FileWriter myWriter;
        myWriter = new FileWriter(fileName, true);
        switch (operationType) {
            case  "insert" :
                tree.insert(element);
                break;
            case "delete":
                tree.deleteKey(element);
                break;
            case "load":
                readFromFile(element,tree);
                break;
            case "find":
                counterSearch++;
                long startTimeSearch = System.nanoTime();
                try {
                    for (int i = 1; i < 51; i++) {
                        Node existence = tree.search(element);
                        //System.out.println("Here "+existence.key);
                        FileWriter findWriter;
                        findWriter = new FileWriter("findElement"+i+".txt", true);
                        findWriter.write(element+",");
                        String value = "";
                        if(existence.equals(tree.root)){
                            findWriter.write("1,"+tree.comparesSearch);
                            value = "Find  - 1";
                        } else {
                            findWriter.write("0,"+tree.comparesSearch);
                            value = "Find - 0";
                        }
//                        if(existence != null){
//                            myWriter.write("1,"+tree.comparesSearch);
//                            value = "Find  - 1";
//                        } else {
//                            myWriter.write("0,"+tree.comparesSearch);
//                            value = "Find - 0";
//                        }
                       // myWriter.write(value + "\n");
                        tree.comparesSearch = 0;
                        findWriter.write("\n");
                        findWriter.close();//findWriter
                    }
//                    String value = "";
//                    if(existence.key.equals(element)){
//                        value = "Find  - 1";
//                    } else {
//                        value = "Find - 0";
//                    }
                } catch (Exception e) {
                    myWriter.write("Find - 0" + "\n");
                }
                long endTimeSearch = System.nanoTime();
                long timeElapsed2 = endTimeSearch - startTimeSearch;
                searchTime += timeElapsed2;
                break;
            case "min":
                counterMin++;
                long startTime = System.nanoTime();
                try {
                    String min = tree.minValueTree(tree.root);
                    myWriter.write("Min "+min + "\n");
                }
                catch(Exception e) {
                    myWriter.write(" "+"\n");
                }
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                minTime += timeElapsed;
                break;
            case "max":
                counterMax++;
                long startTimeMax = System.nanoTime();
                try {
                    String max = tree.maxValueTree(tree.root);
                    myWriter.write("Max "+max + "\n");
                }
                catch(Exception e) {
                    myWriter.write(" "+"\n");
                }
                long endTimeMax = System.nanoTime();
                long timeElapsed3 = endTimeMax - startTimeMax;
                maxTime += timeElapsed3;
                break;
            case "inorder":
                tree.inorder();
                break;
            case "successor":
                counterSuc++;
                long startTimeSuc = System.nanoTime();
                try {
                    String successor = tree.findPreSuc(tree.root,element);
                    myWriter.write("Successor "+successor + "\n");
                } catch (NullPointerException e){
                    System.err.println("0");
                }
                long endTimeSuc = System.nanoTime();
                long timeElapsed4 = endTimeSuc - startTimeSuc;
                sucTime += timeElapsed4;
                break;
            default:
                break;
        }
        myWriter.close();
    }

    private static void readFromFile(String fileName, Tree tree) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("C:\\Users\\Vadym\\Documents\\Lista4\\src\\lab4\\"+fileName));
            while (s.hasNextLine()) {
                String word = s.next();
                if(word.contains(",")) {
                    word = word.replaceAll(",$", "");
                } else if(word.contains(".")) {
                    word = word.replaceAll(".$", "");
                } else if(word.contains(":")) {
                    word = word.replaceAll(":$", "");
                } else if(word.contains(";")) {
                    word = word.replaceAll(";$", "");
                } else if(word.contains("-")) {
                    word = word.replaceAll("-$", "");
                } else if(word.contains("'")) {
                    word = word.replaceAll("'$","");
                } else if(word.startsWith("\"")){
                    word = word.replaceAll("\"$","");
                } else if(word.contains("“")){
                    word = word.replaceAll("“","");
                }
                tree.insert(word);
                list.add(word);
                //System.out.println("word:" + word);
            }
        } catch (Exception e) {
            System.out.print("Error");
        }
//        System.out.println("_______________READER "+tree.counterInsert);
//        for (int i = 0; i < 50; i++) {
//            int random = getRandomInt(0,tree.counterInsert-1);
//            FileWriter writeList;
//            writeList = new FileWriter("words.txt", true);
//            writeList.write( "find "+list.get(random) + "\n");
//            writeList.close();
//        }
    }


    private static int getRandomInt(double min, double max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }

    public static String quote(String text) {
        if (text.contains("\"")) {
            return '"' + text.replaceAll("\"", "\"\"") + '"';
        }
        if (text.contains(",") || text.contains("'"))
            return '"' + text + '"';
        return text;
    }

    private static List<String[]> readOperationType(String fileName) {
        List<String[]> list = new LinkedList<>();
        try {
            Scanner s = new Scanner(new File("C:\\Users\\Vadym\\Documents\\Lista4\\src\\lab4\\"+fileName));
            while (s.hasNextLine()) {
                String word = s.nextLine();
                String[] args = word.split(" ");
                list.add(args);
            }
        } catch (Exception e) {
            System.out.print("Error");
        }
        return list;
    }
}
