import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MapTest {
    private static String fileName = "lotr.txt";
    public static void main(String[] args) throws IOException {
        HMap hMap = new HMap();
        hMap.insert("test");
        hMap.insert("test");
        System.out.println(hMap.search("test"));
        System.out.println(hMap.search("test"));
        System.out.println(hMap.search("lol"));
        System.out.println(hMap.search("xd"));
        hMap.insert("xd");
        System.out.println(hMap.search("xd"));
//        System.out.println(hMap.toString());
        hMap.insert("Aa");
        hMap.insert("BB");
        //System.out.println(hMap.toString());
        hMap.insert("Siblings");
        hMap.insert("Teheran");
        hMap.insert("Dark");
        hMap.delete("Dark");
        System.out.println(hMap.toString());
        readMapFromFile(hMap);
        System.out.println(hMap.toString());
        System.out.println(hMap.toString());
        Scanner s = new Scanner(new File("C:\\Users\\Vadym\\Documents\\Lista4\\src\\cleanedLotrTest.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        int findCounter = 0;
        for (int i = 0; i < list.size()-1; i++) {
            if(hMap.search(list.get(i)))
                findCounter++;
        }
        System.out.println("\nNumber of compares insert: "+hMap.comparesInsert);
        System.out.println("Number of compares delete: "+hMap.comparesDelete);
        System.out.println("Number of compares search: "+hMap.comparesSearch+"\n");
        System.out.println("Time insert: "+hMap.insertTime);
        System.out.println("Time delete: "+hMap.deleteTime);
        System.out.println("Time search: "+hMap.searchTime+"\n");
        System.out.println("Count of inserts: "+hMap.counterInsert);
        System.out.println("Count of deletes: "+hMap.counterDelete);
        System.out.println("Count of searches: "+hMap.counterSearch+"\n");
        System.out.println("Successful searches: "+(findCounter+5));
        System.out.println("Max number of elements: "+hMap.maxNumberOfElements);
        System.out.println("Current number of elements: "+hMap.currentNumberOfElements+"\n");
        System.out.println("Size of hMap: "+hMap.getActualSize());
    }

    private static void readMapFromFile(HMap hMap) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\Vadym\\Documents\\Lista4\\src\\lab4\\"+fileName);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.next();
                if(line.contains(",")) {
                    line = line.replaceAll(",$", "");
                } else if(line.contains(".")) {
                    line = line.replaceAll(".$", "");
                } else if(line.contains(":")) {
                    line = line.replaceAll(":$", "");
                } else if(line.contains(";")) {
                    line = line.replaceAll(";$", "");
                } else if(line.contains("-")) {
                    line = line.replaceAll("-$", "");
                } else if(line.contains("'")) {
                    line = line.replaceAll("'$","");
                } else if(line.startsWith("\"")){
                    line = line.replaceAll("\"$","");
                } else if(line.contains("“")){
                    line = line.replaceAll("“","");
                }
                hMap.insert(line);
//                System.out.println(line);
            }
            inputStream.close();
            sc.close();
        } catch (Exception e){
            System.out.print("Error");
        }
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader("C:\\Users\\Vadym\\Documents\\Lista4\\src\\lab4\\"+fileName));
//            String line = reader.readLine();
//            while (line != null) {
//                String[] words = line.split("\\|");
//                System.out.println(Arrays.toString(words));
//                // read next line
//                line = reader.readLine();
//            }
//            reader.close();
////            while (s.hasNextLine()) {
////                System.out.println("whileP:");
////                String word = s.next();
////                if(word.contains(",")) {
////                    word = word.replaceAll(",$", "");
////                } else if(word.contains(".")) {
////                    word = word.replaceAll(".$", "");
////                } else if(word.contains(":")) {
////                    word = word.replaceAll(":$", "");
////                } else if(word.contains(";")) {
////                    word = word.replaceAll(";$", "");
////                } else if(word.contains("-")) {
////                    word = word.replaceAll("-$", "");
////                } else if(word.contains("'")) {
////                    word = word.replaceAll("'$","");
////                } else if(word.startsWith("\"")){
////                    word = word.replaceAll("\"$","");
////                } else if(word.contains("“")){
////                    word = word.replaceAll("“","");
////                }
////                hMap.insert(word);
////            }
//        } catch (Exception e) {
//            System.out.print("Error");
//        }
    }
}
