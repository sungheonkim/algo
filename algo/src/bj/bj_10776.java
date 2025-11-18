package bj;

import java.util.*;
import java.io.*;

public class bj_10776 {
    static class Edge implements Comparable<Edge>{
        int node, time, totalWear;

        public Edge(int node, int time, int totalWear){
            this.node = node;
            this.time = time;
            this.totalWear = totalWear;
        }

        @Override
        public int compareTo(Edge o){
            return this.time - o.time;
        }
    }

    private static List<Edge>[] graph;
    private static int k, n, m;
    private static int start, end;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 양방향 그래프!
            graph[a].add(new Edge(b, t, h));
            graph[b].add(new Edge(a, t, h));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    }

    private static int dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[][] dist = new int[k][n + 1];

        for(int i = 0; i < k; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.add(new Edge(start, 0, 0));
        dist[0][start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int currentNode = current.node;
            int currentTime = current.time;
            int currentWear = current.totalWear;

            if(dist[currentWear][currentNode] < currentTime) continue;

            for(Edge edge : graph[currentNode]){
                int nextNode = edge.node;
                int edgeTime = edge.time;
                int edgeWear = edge.totalWear;

                int newTime = currentTime + edgeTime;
                int newTotalWear = currentWear + edgeWear;

                if(newTotalWear >= k) continue;

                if(dist[newTotalWear][nextNode] > newTime) {
                    dist[newTotalWear][nextNode] = newTime;
                    pq.add(new Edge(nextNode, newTime, newTotalWear));
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            minTime = Math.min(minTime, dist[i][end]);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}