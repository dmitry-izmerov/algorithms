package ru.demi.algorithms.leetcode.topInterview150.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
 * characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * Constraints:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class TextJustification {

    static List<String> fullJustify(String[] words, int maxWidth) {
        var res = new ArrayList<String>();
        var len = 0;
        var row = new ArrayList<String>();
        for (var i = 0; i < words.length;) {
            var w = words[i];
            if (len + w.length() > maxWidth) {
                var spaces = Math.max(1, row.size() - 1);
                var extraSpaces = maxWidth - (len - 1);
                var spacesPerWord = extraSpaces / spaces;
                var leftSpaces = extraSpaces % spaces;
                for (var j = 0; j < spaces; j++) {
                    row.set(j, row.get(j) + " ".repeat(spacesPerWord));
                }
                for (var j = 0; j < leftSpaces; j++) {
                    row.set(j, row.get(j) + " ");
                }
                res.add(String.join(" ", row));
                len = 0;
                row = new ArrayList<>();
            } else {
                row.add(w);
                i++;
                len += w.length() + 1;
            }
        }

        if (!row.isEmpty()) {
            var str = String.join(" ", row);
            var diff = maxWidth - str.length();
            if (diff > 0) {
                str += " ".repeat(diff);
            }
            res.add(str);
        }

        return res;
    }
}
