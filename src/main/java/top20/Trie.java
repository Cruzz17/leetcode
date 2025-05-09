package top20;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Trie {
    private Trie[] links;
    private boolean isEnd;

    public Trie() {
        links = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.links[index] == null) {
                node.links[index] = new Trie();
            }
            node = node.links[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            node = node.links[word.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.links[prefix.charAt(i) - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}