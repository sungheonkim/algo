import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int to,cost;
        public Edge(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }
    }
    private static List<Edge>[] list;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list=new ArrayList[n+1];

        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<fares.length;i++){
            int from=fares[i][0];
            int to=fares[i][1];
            int cost=fares[i][2];
            list[from].add(new Edge(to,cost));
            list[to].add(new Edge(from,cost));
        }

        int[] dijA=dij(n,a);
        int[] dijB=dij(n,b);
        int[] dijS=dij(n,s);

        for(int i=1;i<n+1;i++){
            answer=Math.min(answer,dijA[i]+dijB[i]+dijS[i]);
        }

        return answer;
    }
    private static int[] dij(int n,int start){
        int[] dist=new int[n+1];
        PriorityQueue<Edge> pq=new PriorityQueue<>();

        int INF=Integer.MAX_VALUE;
        Arrays.fill(dist,INF);

        pq.add(new Edge(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(dist[curr.to]<curr.cost){
                continue;
            }
            for(Edge next : list[curr.to]){
                int nextCost=next.cost+dist[curr.to];
                if(nextCost<dist[next.to]){
                    dist[next.to]=nextCost;
                    pq.add(new Edge(next.to,nextCost));
                }
            }
        }

        return dist;

    }
}