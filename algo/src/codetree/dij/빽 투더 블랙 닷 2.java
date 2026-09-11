import java.util.*;
import java.io.*;
//n개 지점, m개 간선
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
    private static final int INF = (int) 1e8;
    private static List<Edge>[] list;
    private static int n,m,r1,r2;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        r1=Integer.parseInt(st.nextToken());
        r2=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];

        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b,cost));
            list[b].add(new Edge(a,cost));
        }
        int[] r1Dist=dij(r1);
        int[] r2Dist=dij(r2);

        int ans=INF;
        for (int i = 1; i <= n; i++) {
            if (i == r1 || i == r2) continue;

            if (r1Dist[i] == INF || r2Dist[i] == INF || r1Dist[r2] == INF) continue;

            int totalDist = r1Dist[i] + r1Dist[r2] + r2Dist[i];

            ans = Math.min(ans, totalDist);
        }
        System.out.println(ans==INF?-1:ans);
    }
    private static int[] dij(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[] dist=new int[n+1];
        Arrays.fill(dist,INF);

        dist[start]=0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge curr= pq.poll();

            if(dist[curr.index]<curr.dist) continue;

            for(Edge next : list[curr.index]){
                int nextCost=dist[curr.index]+next.dist;

                if(nextCost<dist[next.index]){
                    pq.add(new Edge(next.index,nextCost));
                    dist[next.index]=nextCost;
                }

            }

        }

        return dist;

    }
}