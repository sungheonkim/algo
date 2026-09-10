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
    private static int n,a,b;
    private static char[][] map;
    private static List<Edge>[] graph;

    private static int[] dr={1,-1,0,0};
    private static int[] dc={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());


        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j);
            }
        }

        int totalNode=n*n;
        graph=new ArrayList[totalNode];
        for(int i=0;i<totalNode;i++){
            graph[i]=new ArrayList<>();
        }
        make(); // 그래프 만들기 정점


        //모든 칸에서 다익스트라
        int maxDist=0;
        for(int i=0;i<totalNode;i++){
            int localMax=dij(i);
            maxDist=Math.max(maxDist,localMax);
        }

        System.out.println(maxDist);


    }
    private static int getIndex(int r,int c){
        return r*n+c;
    }
    private static void make(){
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                int u=getIndex(r,c);

                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];

                    if(nr>=0 && nr<n &&nc>=0 && nc<n){
                        int v=getIndex(nr,nc);
                        //같은 괄호인지
                        int cost=(map[r][c]==map[nr][nc]) ? a:b;
                        graph[u].add(new Edge(v,cost));
                    }
                }
            }
        }
    }
    private static int dij(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[] dist=new int[n*n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start]=0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(curr.dist>dist[curr.index]) continue;

            for(Edge next:graph[curr.index]){
                int nextDist=dist[curr.index]+next.dist;

                if(nextDist<dist[next.index]){
                    dist[next.index]=nextDist;
                    pq.add(new Edge(next.index,nextDist));
                }
            }
        }
        int max=0;
        for(int d:dist){
            if(d!=Integer.MAX_VALUE){
                max=Math.max(max,d);
            }
        }
        return max;

    }
}