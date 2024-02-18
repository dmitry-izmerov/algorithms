package ru.demi.algorithms.leetcode.topInterview150.oneDDP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreak {
    List<String> wordDict;
    Map<String, Boolean> cache;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        cache = new HashMap<>();
        return canBreak(s);
    }

    boolean canBreak(String s) {
        if (cache.containsKey(s)) return cache.get(s);
        if (s.isEmpty()) return true;

        var res = false;
        for (var w : wordDict) {
            if (s.startsWith(w)) {
                res = res || canBreak(s.substring(w.length()));
            }
        }
        cache.put(s, res);

        return res;
    }
}
