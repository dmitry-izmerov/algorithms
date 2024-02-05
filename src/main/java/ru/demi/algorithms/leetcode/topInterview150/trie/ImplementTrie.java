package ru.demi.algorithms.leetcode.topInterview150.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in
 * a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false
 * otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix,
 * and false otherwise.
 *
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */
public class ImplementTrie {
    private Node root;

    class Node {
        Map<Character, Node> nodes = new HashMap<>();
        boolean isWord;
    }

    public ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        var node = root;
        for (var i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            var next = node.nodes.getOrDefault(c, new Node());
            node.nodes.put(c, next);
            node = next;
        }
        node.isWord = true;
    }

    Node searchPrefix(String word) {
        var node = root;
        for (var i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            var next = node.nodes.get(c);
            if (next == null) return null;
            node = next;
        }
        return node;
    }

    public boolean search(String word) {
        var node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
