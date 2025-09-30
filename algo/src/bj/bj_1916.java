package bj;
import java.io.*;
import java.util.*;

public class bj_1916 {
    static class Edge implements Comparable<Edge>{
        int next;
        int cost;
        public Edge(int next,int cost){
            this.next=next;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }
    }
    private static int n,m;
    private static List<Edge>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        list=new ArrayList[n+1];

        for (int i = 0; i <=n; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int next=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            list[start].add(new Edge(next,cost));
        }
        st=new StringTokenizer(br.readLine());

        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        int result= dij(start,end);
        System.out.println(result);
    }
    private static int dij(int start,int end){
        int[] dist=new int[n+1];
        int tmp=Integer.MAX_VALUE;
        Arrays.fill(dist,tmp);

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Edge curr=pq.poll();

            if(curr.cost>dist[curr.next]) continue;

            for (int i = 0; i <list[curr.next].size() ; i++) {
                Edge edge=list[curr.next].get(i);
                int next=edge.next;
                int nextCost=edge.cost+curr.cost;
                if(nextCost<dist[next]){
                    dist[next]=nextCost;
                    pq.add(new Edge(next,nextCost));
                }
            }
        }


        return dist[end];
    }
}
