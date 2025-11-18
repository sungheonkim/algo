package bj;
import java.util.*;
import java.io.*;
public class swea_1249 {
    static class Edge implements Comparable<Edge>{
        int x,y,cost;
        public Edge(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }
    }
    private static StringBuilder sb=new StringBuilder();
    private static int n;
    private static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for (int t = 1; t <=T; t++) {
            n=Integer.parseInt(br.readLine());
            map=new int[n][n];
            for (int i = 0; i <n ; i++) {
                String str=br.readLine();
                for (int j = 0; j <n ; j++) {
                    map[i][j]=str.charAt(j)-'0';
                }
            }
            int dis= dij();
            sb.append('#').append(t).append(' ').append(dis).append('\n');
        }
        System.out.println(sb);
    }
    private static int dij(){
        int[] dx= {1,-1,0,0};
        int[] dy= {0,0,-1,1};

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[][] dist=new int[n][n];

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }


        pq.add(new Edge(0,0,0));
        dist[0][0]=0;

        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(curr.cost>dist[curr.x][curr.y]) continue;
            for (int i = 0; i < 4; i++) {
                int nx=curr.x+dx[i];
                int ny=curr.y+dy[i];
                if(nx>=0 &&nx<n&&ny>=0&&ny<n){
                    if(curr.cost+map[nx][ny]<dist[nx][ny]){
                        dist[nx][ny]=curr.cost+map[nx][ny];
                        pq.add(new Edge(nx,ny,curr.cost+map[nx][ny]));
                    }
                }
            }
        }


        return dist[n-1][n-1];
    }
}
