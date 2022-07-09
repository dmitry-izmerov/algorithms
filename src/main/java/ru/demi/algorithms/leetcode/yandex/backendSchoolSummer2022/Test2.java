package ru.demi.algorithms.leetcode.yandex.backendSchoolSummer2022;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Test2 {

    private static Map<String, Integer> occupations = new HashMap<>();
    private static Map<String, PriorityQueue<CandidateInfo>> candidates = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(r.readLine());
        for (int i = 0; i < n; i++) {
            String line = r.readLine();
            String[] split = line.split(",");
            String occupation = split[0];
            int maxCandidates = Integer.parseInt(split[1]);
            occupations.put(occupation, maxCandidates);
            candidates.put(occupation, new PriorityQueue<>());
        }

        int k = Integer.parseInt(r.readLine());
        for (int i = 0; i < k; i++) {
            String line = r.readLine();
            String[] split = line.split(",");
            String occupation = split[1];
            candidates.get(occupation).add(createCandidateInfo(split));
        }

        List<String> result = new ArrayList<>();
        candidates.forEach((key, val) -> {
            int max = occupations.get(key);
            for (int i = 0; i < max && !val.isEmpty(); i++) {
                result.add(val.poll().id);
            }
        });

        result.stream().sorted().forEach(System.out::println);
    }

    private static CandidateInfo createCandidateInfo(String[] data) {
        String id = data[0];
        String occupation = data[1];
        int solved = Integer.parseInt(data[2]);
        int penalty = Integer.parseInt(data[3]);
        return new CandidateInfo(id, occupation, solved, penalty);
    }

    private static final class CandidateInfo implements Comparable<CandidateInfo> {
        private final String id;
        private final String occupation;
        private final int solved;
        private final int penalty;

        private CandidateInfo(String id, String occupation, int solved, int penalty) {
            this.id = id;
            this.occupation = occupation;
            this.solved = solved;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(CandidateInfo o) {
            if (solved != o.solved) {
                return o.solved - solved;
            }
            return penalty - o.penalty;
        }

        public String id() {
            return id;
        }

        public String occupation() {
            return occupation;
        }

        public int solved() {
            return solved;
        }

        public int penalty() {
            return penalty;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (CandidateInfo) obj;
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.occupation, that.occupation) &&
                    this.solved == that.solved &&
                    this.penalty == that.penalty;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, occupation, solved, penalty);
        }

        @Override
        public String toString() {
            return "CandidateInfo[" +
                    "id=" + id + ", " +
                    "occupation=" + occupation + ", " +
                    "solved=" + solved + ", " +
                    "penalty=" + penalty + ']';
        }

    }
}
