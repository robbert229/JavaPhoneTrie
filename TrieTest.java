import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by RowleyJohn on 10/15/2016.
 */
public class TrieTest {
    @org.junit.Test
    public void insert() throws Exception {
        Trie t = new Trie();
        t.insert("foo");
        t.insert("bar");

        Assert.assertTrue(t.containsWord("foo"));
        Assert.assertTrue(t.containsWord("bar"));
        Assert.assertEquals(2, t.size());
    }

    @org.junit.Test
    public void size() throws Exception {
        Trie t = new Trie();

        t.insert("foo");
        t.insert("foo");

        Assert.assertEquals(2, t.size());
    }

    @org.junit.Test
    public void containsWord() throws Exception {
        Trie t = new Trie();

        t.insert("foolio");

        Assert.assertEquals(false, t.containsWord("fool"));
        Assert.assertEquals(true, t.containsWord("foolio"));
    }

    @org.junit.Test
    public void searchPrefix() throws Exception {
        Trie t = new Trie();

        t.insert("foolio");
        t.insert("fool");
        t.insert("fat");
        t.insert("bat");

        Assert.assertEquals(2, t.searchPrefix("fool").size());
        Assert.assertEquals(3, t.searchPrefix("f").size());
        Assert.assertEquals(0, t.searchPrefix("apples").size());
    }

    @org.junit.Test
    public void searchPhone() throws Exception {

    }

}