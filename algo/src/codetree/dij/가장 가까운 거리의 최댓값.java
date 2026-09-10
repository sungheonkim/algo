import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int index,dist;
        public Edge(int index,int dist){
            this.index=index;
            this.dist=dist;
        }
        @Override
        public int compareTo(Edge o){
            return this.dist-o.dist;
        }

    }
    private static int n,m,a,b,c;
    private static List<Edge>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        graph=new ArrayList[n+1];

        for(int i=1;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to,dist));
            graph[to].add(new Edge(from,dist));

        }
        int[] distA=dij(a);
        int[] distB=dij(b);
        int[] distC=dij(c);

        int ans=0;

        for(int i=1;i<=n;i++){
            int minDist=Math.min(distA[i],Math.min(distB[i],distC[i]));

            ans=Math.max(ans,minDist);
        }
        System.out.println(ans);
    }
    private static int[] dij(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start]=0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(curr.dist>dist[curr.index]) continue;

            for(Edge next:graph[curr.index]){
                int nextDist=dist[curr.index]+next.dist;

                if(nextDist< dist[next.index]){
                    dist[next.index]=nextDist;
                    pq.add(new Edge(next.index,nextDist));
                }
            }
        }
        return dist;
    }
}