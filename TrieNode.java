import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by RowleyJohn on 10/15/2016.
 */
class TrieNode {
    HashMap<Character, TrieNode> _children;
    boolean _isEnd;
    String _word;

    public TrieNode() {
        _children = new HashMap<>();
        _isEnd = false;
    }

    /**
     * Returns the all of this nodes descendants who are words.
     * @return
     */
    public List<TrieNode> getDescendantWords(){
        List<TrieNode> nodes = new ArrayList<>();
        Stack<TrieNode> nodeStack = new Stack<>();

        this._children
                .values()
                .parallelStream()
                .forEach(nodeStack::push);

        while(!nodeStack.empty()){
            TrieNode iter = nodeStack.pop();

            if(iter._isEnd)
                nodes.add(iter);

            iter._children
                    .values()
                    .parallelStream()
                    .forEach(nodeStack::push);
        }

        return nodes;
    }
}