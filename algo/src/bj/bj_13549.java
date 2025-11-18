package bj;
import java.util.*;
import java.io.*;

public class bj_13549 {
    static class Edge implements Comparable<Edge>{
        int cost,loc;
        public Edge(int loc,int cost){
            this.cost=cost;
            this.loc=loc;
        }
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }
    }
    private static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int result = dij();
        System.out.println(result);

    }
    private static int dij(){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[] dist=new int[100_000+1]; //최대 거리까지
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[n]=0;
        pq.add(new Edge(n,0));

        while(!pq.isEmpty()){
            Edge curr=pq.poll();

            if(dist[curr.loc]<curr.cost) continue;

            int nLoc=curr.loc-1;
            if(nLoc>=0&&nLoc<100_000&&dist[nLoc]>curr.cost+1){
                dist[nLoc]=curr.cost+1;
                pq.add(new Edge(nLoc,dist[nLoc]));
            }

            nLoc=curr.loc+1;
            if(nLoc>=0&&nLoc<100_000&&dist[nLoc]>curr.cost+1){
                dist[nLoc]=curr.cost+1;
                pq.add(new Edge(nLoc,dist[nLoc]));
            }

            nLoc=curr.loc*2;
            if(nLoc>=0&&nLoc<100_000&&dist[nLoc]>curr.cost){
                dist[nLoc]=curr.cost;//시간 그대로
                pq.add(new Edge(nLoc,dist[nLoc]));
            }


        }
        return dist[m];


    }
}
