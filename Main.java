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
        Trie t = buildTrieFromFile("dictionary.txt");

        Scanner kb = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a word or comma separated integers -> ");
            String line = kb.nextLine();
            
            if(line.compareTo("exit") == 0)
                return;
            
            try {
                List<String> words = parseLine(line, t);
                printResults(words);
            } catch (Exception e){
                System.out.println("Invalid Input - " + e.getMessage());
            }
        }
    }

    private static void printResults(List<String> words){
        System.out.println("Results");
        for(String word : words){
            System.out.println("\t" + word);
        }
    }

    private static List<String> parseLine(String line, Trie t){
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

        return words;
    }

    private static Trie buildTrieFromFile(String filename) throws FileNotFoundException {
        Trie t = new Trie();
        Scanner fin = new Scanner(new File(filename));

        System.out.println("Reading File");

        while(fin.hasNextLine()){
            String line = fin.nextLine();
            String[] tokens = line.split(",");
            t.insert(tokens[0].toLowerCase());
        }

        System.out.println("Trie Loaded, size: " + t.size());

        return t;
    }
}
