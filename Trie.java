import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RowleyJohn on 10/15/2016.
 */
public class Trie {
    private TrieNode root;
    private int _size;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * inserts a word into the tree.
     * @param word
     */
    public void insert(String word) {
        TrieNode iter = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(iter._children.get(c) == null){
                TrieNode temp = new TrieNode();
                iter._children.put(c, temp);
                iter = temp;
            } else {
                iter = iter._children.get(c);
            }
        }

        _size++;
        iter._isEnd = true;
        iter._word = word;
    }

    /**
     * returns the number of words inside of the tree.
     * @return
     */
    public int size(){
        return _size;
    }

    /**
     * containsWord returns if the trie contains the specified word.
     * @param word
     * @return
     */
    public boolean containsWord(String word){
        TrieNode n = searchNode(word);
        return n != null && n._isEnd;
    }

    /**
     * searchPrefix returns all words that start with the given prefix.
     * @param prefix
     * @return
     */
    public List<String> searchPrefix(String prefix){
        TrieNode prefixNode = searchNode(prefix);
        List<String> children = new ArrayList<>();

        if(prefixNode != null) {
            if(prefixNode._isEnd)
                children.add(prefixNode._word);

            List<TrieNode> childrenNodes = prefixNode.getDescendantWords();

            children.addAll(childrenNodes.parallelStream().map(n->n._word).collect(Collectors.toList()));
        }
        return children;
    }


    private TrieNode searchNode(String prefix){
        TrieNode iter = root;
        for(int i = 0;i < prefix.length();i++){
            char index = prefix.charAt(i);
            iter = iter._children.get(index);
            if(iter == null)
                return null;
        }

        return iter;
    }

    /**
     * searchPhone returns the words in the trie that could be spelled with the given numbers list.
     * @param numbers
     * @return
     */
    public List<String> searchPhone(int[] numbers){
        return searchPhone(root, numbers, 0)
                .parallelStream()
                .map(n -> n._word)
                .collect(Collectors.toList());
    }

    private List<TrieNode> searchPhone(TrieNode root, int[] numbers, int index){
    if(index == numbers.length){
        List<TrieNode> ret = new ArrayList<TrieNode>();
        if(root._isEnd)
            ret.add(root);
        return ret;
    }

        List<TrieNode> nodes = childrenFromNumber(root, numbers[index]);

        return nodes.parallelStream().map(n -> searchPhone(n, numbers, index + 1)).flatMap(
                Collection::stream
        ).collect(Collectors.toList());
    }

    private List<TrieNode> childrenFromNumber(TrieNode root, int number){
        List<TrieNode> nodes = new ArrayList<TrieNode>();
        TrieNode temp;

        if(root == null){
            return nodes;
        }

        else if(number == 2){
            temp = root._children.get('a');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('b');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('c');
            if(temp != null)
                nodes.add(temp);
        } else if (number == 3){
            temp = root._children.get('d');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('e');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('f');
            if(temp != null)
                nodes.add(temp);

        } else if (number == 4){
            temp = root._children.get('g');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('h');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('i');
            if(temp != null)
                nodes.add(temp);

        } else if (number == 5){
            temp = root._children.get('j');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('k');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('l');
            if(temp != null)
                nodes.add(temp);

        } else if (number == 6){
            temp = root._children.get('m');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('n');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('o');
            if(temp != null)
                nodes.add(temp);

        } else if(number == 7){
            temp = root._children.get('p');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('q');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('r');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('s');
            if(temp != null)
                nodes.add(temp);

        } else if(number == 8){
            temp = root._children.get('t');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('u');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('v');
            if(temp != null)
                nodes.add(temp);

        } else if(number == 9){
            temp = root._children.get('w');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('x');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('y');
            if(temp != null)
                nodes.add(temp);

            temp = root._children.get('z');
            if(temp != null)
                nodes.add(temp);

        } else {
            throw new IllegalArgumentException("Invalid number '" + number + "'");
        }

        return nodes;
    }
}