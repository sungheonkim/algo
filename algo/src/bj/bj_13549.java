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
    private static int n,k;
    private static int MAX_VALUE=100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        int result = dij();
        System.out.println(result);

    }
    private static int dij(){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[] dist=new int[MAX_VALUE+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        pq.add(new Edge(n,0)); //출발
        dist[n]=0;

        while(!pq.isEmpty()){
            Edge curr=pq.poll();

            int currCost=curr.cost;
            int currLoc=curr.loc;

            if(dist[currLoc]<currCost) continue;

//            System.out.println("현재 위치:"+currLoc+"현재소요시간:"+currCost);

            int nextLoc=currLoc-1;
            if(isRange(nextLoc)){
                if(dist[nextLoc]>currCost+1){
                    dist[nextLoc]=currCost+1;
                    pq.add(new Edge(nextLoc,dist[nextLoc]));
                }
            }

            nextLoc= currLoc+1;
            if(isRange(nextLoc)){
                if(dist[nextLoc]>currCost+1){
                    dist[nextLoc]=currCost+1;
                    pq.add(new Edge(nextLoc,dist[nextLoc]));
                }
            }

            nextLoc= currLoc*2;
            if(isRange(nextLoc)){
                if(dist[nextLoc]>currCost){
                    dist[nextLoc]=currCost;
                    pq.add(new Edge(nextLoc,dist[nextLoc]));

                }
            }
        }
        return dist[k];
    }
    private static boolean isRange(int location){
        return location>=0 && location<=MAX_VALUE;
    }
}
