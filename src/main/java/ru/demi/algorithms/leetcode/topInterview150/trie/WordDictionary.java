package ru.demi.algorithms.leetcode.topInterview150.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 *
 * Example:
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * Constraints:
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 10^4 calls will be made to addWord and search.
 */
public class WordDictionary {
    Node root = new Node();

    class Node {
        Map<Character, Node> nodes = new HashMap<>();
        boolean isWord = false;
    }

    public WordDictionary() {
    }

    public void addWord(String word) {
        var cur = root;
        for (var c : word.toCharArray()) {
            var next = cur.nodes.getOrDefault(c, new Node());
            cur.nodes.put(c, next);
            cur = next;
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    boolean search(String word, Node cur) {
        for (var i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (!cur.nodes.containsKey(c)) {
                if (c != '.') return false;

                for (var node : cur.nodes.values()) {
                    if (search(word.substring(i + 1), node)) {
                        return true;
                    }
                }
                return false;
            } else {
                cur = cur.nodes.get(c);
            }
        }
        return cur.isWord;
    }
}
