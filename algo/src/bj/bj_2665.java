package bj;

import java.util.*;
import java.io.*;

public class bj_2665 {
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
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    private static int n;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        map=new int[n][n];
        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j)-'0';
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        int result=dij();

        System.out.println(result);

    }
    private static int bfs(){
        Queue<int[]> q=new LinkedList<>();
        int[][] visited=new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }

        q.add(new int[]{0,0});
        visited[0][0]=0;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            for (int i = 0; i < 4; i++) {
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n ){
                    // 벽을 몇번 부셨는지 값을 들고가면서, 최소값을 위해 비교
                    if(visited[nx][ny]>visited[curr[0]][curr[1]]) {

                        if (map[nx][ny] == 1) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = visited[curr[0]][curr[1]];
                        }else if(map[nx][ny]==0){
                            q.add(new int[]{nx,ny});
                            visited[nx][ny]=visited[curr[0]][curr[1]]+1;
                        }
                    }
                }
            }
        }
        return visited[n-1][n-1];
    }
    private static int dij(){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int[][] dist=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        pq.add(new Edge(0,0,0));
        dist[0][0]=0;


        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            int cX=curr.x;
            int cY=curr.y;
            int cCost=curr.cost;
            if(dist[cX][cY]<cCost) continue;

            for (int i = 0; i <4 ; i++) {
                int nX=cX+dx[i];
                int nY=cY+dy[i];
                if(nX>=0 && nX<n && nY>=0 &&nY<n){
                    int nCost=cCost;
                    if(map[nX][nY]==0) {
                        nCost+=1;
                    }
                    if(dist[nX][nY]>nCost) {

                        dist[nX][nY] = nCost;
                        pq.add(new Edge(nX, nY, nCost));
                    }
                }
            }
        }
        return dist[n-1][n-1];

    }
}
