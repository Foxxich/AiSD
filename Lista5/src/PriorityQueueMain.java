import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueMain {

    private static final int CAPACITY = 1000;
    private static long timeElapsed;
    private static final String FILE = "PQ.txt";

    public static void main(String[] args)
    {
        for (int j = 1; j <= 50; j++) {
            long startTime = System.nanoTime();
            PriorityQueue pq = new PriorityQueue(CAPACITY);
//            System.out.println("\nSize = "+ pq.size() );
            List<String> list = new ArrayList<>();
            for (int i = 0; i < CAPACITY; i++) {
                String wordToInsert = createRandomWord(getRandomNumber(0,50));
                pq.insert(wordToInsert, getRandomNumber(0,1000));
                list.add(wordToInsert);
            }
//        pq.insert("TEST",1);
//        pq.insert("AAA",0);
//        System.out.println("\nSize = "+ pq.size() );
//        pq.top();
//        pq.pop();
//        System.out.println("\nSize = "+ pq.size() );
//        pq.top();
//        pq.priority("TEST",0);
//        pq.top();
//        System.out.println("__________________");
//        pq.insert("AAA",6);
//        pq.insert("I_LIKE_TESTS",5);
//        pq.insert("OHHHHFFF",0);
            pq.print();
            System.out.println("\nSize = "+ pq.size() );
            int size  = pq.size();
            System.out.println("Insert compares = "+ pq.insertCompares );
            System.out.println("Print compares = "+ pq.printCompares );
            for (int i = 0; i < CAPACITY; i++) {
                pq.priority(list.get(i), getRandomNumber(0,1000));
            }
            System.out.println("Priority compares = "+ pq.priorityCompares );
            for (int i = 0; i < CAPACITY; i++) {
                pq.pop();
            }
            System.out.println("Pop compares = "+ pq.removeCompares);
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time "+ timeElapsed);
            printResult(j, size, pq.insertCompares, pq.printCompares, pq.priorityCompares, pq.removeCompares);
        }
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

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void printResult(int i, int number, int insert, int print, int priority, int pop) {
        try {
            FileWriter myWriter = new FileWriter(FILE,true);
            myWriter.write(i+"    "+number+"    "+insert+"   "+print+"   "+priority+"   "+pop+"   "+timeElapsed);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
