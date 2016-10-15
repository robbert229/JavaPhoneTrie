import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RowleyJohn on 10/15/2016.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Trie t = new Trie();
        Scanner fin = new Scanner(new File("words.txt"));

        System.out.println("Reading File");

        while(fin.hasNextLine()){
            String line = fin.nextLine();
            t.insert(line.toLowerCase());
        }

        System.out.println("Trie Loaded, size: " + t.size());

        Scanner kb = new Scanner(System.in);
        String line;

        do {
            System.out.print("Enter a word or comma seperated integers -> ");
            line = kb.nextLine();

            List<String> words;
            if(line.contains(",")){
                words = t.searchPhone(
                        Arrays.asList(line.split(","))
                                .parallelStream()
                                .mapToInt(Integer::parseInt)
                                .toArray());
            } else {
                words = t.searchPrefix(line);
            }

            System.out.println("Results");
            for(String word : words){
                System.out.println("\t" + word);
            }
        } while(!line.equals("exit"));

    }
}
