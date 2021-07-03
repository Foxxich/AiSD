import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    List<List<Task>> adjacentList = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    public static final int V = 8;
    public static final String fileName = "g"+V;

    Graph() throws FileNotFoundException {
        for (int i = 0; i < V; i++) {
            adjacentList.add(new ArrayList<>());
        }
//        adjacentList.get(0).add(new Task("1",4));
//        adjacentList.get(0).add(new Task("5",8));
//
//        adjacentList.get(1).add(new Task("0",4));
//        adjacentList.get(1).add(new Task("2",8));
//        adjacentList.get(1).add(new Task("5",11));
//
//        adjacentList.get(2).add(new Task("1",8));
//        adjacentList.get(2).add(new Task("3",2));
//
//        adjacentList.get(3).add(new Task("2",2));
//        adjacentList.get(3).add(new Task("4",6));
//        adjacentList.get(3).add(new Task("5",7));
//
//        adjacentList.get(4).add(new Task("3",6));
//        adjacentList.get(4).add(new Task("5",1));
//
//        adjacentList.get(5).add(new Task("0",8));
//        adjacentList.get(5).add(new Task("1",11));
//        adjacentList.get(5).add(new Task("3",7));
//        adjacentList.get(5).add(new Task("4",1));
//
//        adjacentList.get(4).add(new Task("5",0.35));
        Scanner s = new Scanner(new File("C:\\Users\\Vadym\\Documents\\Lista5\\src\\lab5\\"+fileName+".txt"));
        skipLines(s, 2);
        while (s.hasNext()) {
            String line = s.next();
            list.add(line);
        }
        for (int i = 0; i < list.size(); i+=3) {

            int getFromAsInt = Integer.parseInt(list.get(i));
            String nameString = list.get(i+1);

            double priority = Double.parseDouble(list.get(i+2));

            adjacentList.get(getFromAsInt).add(new Task(nameString,priority));
//            System.out.println(getFromAsInt+" , "+nameString+" , "+priority);
        }
    }
    
    public static void skipLines(Scanner s,int lineNum){
        for(int i = 0; i < lineNum;i++){
            if(s.hasNextLine())s.nextLine();
        }
    }
}