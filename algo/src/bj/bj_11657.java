package bj;
import java.util.*;
import java.io.*;
public class bj_11657 {
    static class Edge{
        int from,to,cost;
        public Edge(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    private static int n,m;
    private static long INF=Long.MAX_VALUE;
    private static List<Edge> list=new ArrayList<>();
    private static long[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken()); //도시
        m=Integer.parseInt(st.nextToken());//노선갯수

        dist=new long[n+1];

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            list.add(new Edge(from,to,cost));
        }
        StringBuilder sb=new StringBuilder();
        if(bell()) System.out.println(-1);
        else{
            for (int i = 2; i <=n ; i++) {
                if(dist[i]==INF) sb.append("-1").append('\n');
                else sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);

    }
    private static boolean bell(){
        Arrays.fill(dist,INF);
        dist[1]=0; //출발

        for (int i =1; i <=n; i++) {
            for(Edge edge: list){
                int from=edge.from;
                int to=edge.to;
                int cost=edge.cost;

                if(dist[from]==INF) continue;

                long newCost=dist[from]+cost;
                if(dist[to]>newCost){
                    dist[to]=newCost;
                    //음수 사이클 존재하는지
                    if(i==n) return true;
                }
            }
        }
        return false;
    }
}
