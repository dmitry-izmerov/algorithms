package ru.demi.algorithms.leetcode.topInterview150.graphBFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation
 * is defined as one single character changed in the gene string.
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank that records all the valid gene mutations. A gene must be in bank to make it a valid
 * gene string.
 * Given the two gene strings startGene and endGene and the gene bank, return the minimum number of mutations
 * needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 * Example 1:
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * Example 2:
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 *
 * Constraints:
 * 0 <= bank.length <= 10
 * startGene.length == endGene.length == bank[i].length == 8
 * startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']
 */
public class MinimumGeneticMutation {
    List<Character> chars = List.of('A', 'C', 'G', 'T');

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        var genesBank = Arrays.stream(bank).collect(Collectors.toSet());
        var visited = new HashSet<String>();
        var q = new LinkedList<String>();
        q.add(startGene);
        var minChanges = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var cur = q.remove();
                visited.add(cur);
                if (cur.equals(endGene)) {
                    return minChanges;
                }

                for (var j = 0; j < cur.length(); j++) {
                    var ch = cur.charAt(j);
                    for (var c : chars) {
                        if (c == ch) continue;
                        var sb = new StringBuilder(cur);
                        sb.setCharAt(j, c);
                        var next = sb.toString();
                        if (!genesBank.contains(next) || visited.contains(next)) continue;
                        q.add(next);
                    }
                }
            }
            minChanges++;
        }

        return -1;
    }
}
