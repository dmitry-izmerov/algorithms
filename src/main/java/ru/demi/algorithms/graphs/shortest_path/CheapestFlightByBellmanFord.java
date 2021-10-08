package ru.demi.algorithms.graphs.shortest_path;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheapestFlightByBellmanFord {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Flight> list = Arrays.stream(flights)
            .map(f -> new Flight(f[0], f[1], f[2]))
            .collect(Collectors.toList());

        int[] previous = new int[n];
        int[] current = new int[n];
        Arrays.fill(previous, Integer.MAX_VALUE);
        Arrays.fill(current, Integer.MAX_VALUE);
        previous[src] = 0;
        current[src] = 0;

        for (int i = 0; i <= k; ++i) {
            for (Flight f : list) {
                if (previous[f.from] == Integer.MAX_VALUE) {
                    continue;
                }
                current[f.to] = Math.min(current[f.to], previous[f.from] + f.cost);
            }
            previous = current.clone();
        }
        return current[dst] != Integer.MAX_VALUE ? current[dst] : -1;
    }

    private record Flight(int from, int to, int cost) {}
}
