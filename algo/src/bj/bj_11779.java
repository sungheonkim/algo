package bj;
import java.util.*;
import java.io.*;

public class bj_11779 {
    static class Edge implements Comparable<Edge>{
        int to;
        long cost;
        public Edge(int to,long cost){
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o){
            return Long.compare(this.cost,o.cost);
        }
    }
    private static int n,m,start,end,cnt;
    private static List<Edge>[] list;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        list=new ArrayList[n+1];
        parent=new int[n+1];


        for (int i = 0; i <=n ; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to,cost));
        }
        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());

        long result=dij();

        //역추적해야됨
        int curr= end; 
        List<Integer> num=new ArrayList<>();
        sb.append(result).append('\n');
        
        while(curr!=0){
            num.add(curr);
            if(curr==start) break; // 출발 노드까지 오면 끝
            curr=parent[curr];
        }

        sb.append(num.size()).append('\n');

        for (int i = num.size()-1; i>=0 ; i--) {
            sb.append(num.get(i)).append(' ');
        }
        System.out.println(sb);

    }
    private static long dij(){
        long INF = Long.MAX_VALUE;
        long[] dist=new long[n+1];
        PriorityQueue<Edge> pq=new PriorityQueue<>();

        Arrays.fill(dist,INF);

        pq.add(new Edge(start,0));
        dist[start]=0;
        
        while(!pq.isEmpty()){
            Edge curr= pq.poll();
            int index=curr.to;
            long cost=curr.cost;

            if(dist[curr.to]<cost) continue;
            for (int i = 0; i < list[index].size(); i++) {
                Edge tmp= list[index].get(i);
                long nextCost=tmp.cost+dist[index];
                if(nextCost<dist[tmp.to]){
                    parent[tmp.to]=index; //부모 넣어주기
                    pq.add(new Edge(tmp.to,nextCost));
                    dist[tmp.to]=nextCost;
                }
            }
        }

        return dist[end];
    }

}
