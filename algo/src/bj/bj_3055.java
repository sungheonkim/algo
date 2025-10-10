package bj;
import java.util.*;
import java.io.*;

public class bj_3055 {
    static class Edge{
        int x,y,time;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Edge(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }

    private static int n,m;
    private static char[][] map;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new char[n][m];
        Edge d = null;
        Edge s = null;
        Queue<Edge> wq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j <m ; j++) {
                map[i][j]=str.charAt(j);
                if(map[i][j]=='D'){
                    d=new Edge(i,j);
                }
                if(map[i][j]=='S'){
                    s=new Edge(i,j, 0);
                }
                if(map[i][j]=='*'){
                    wq.add(new Edge(i,j));
                }
            }
        }

        int result = bfs(d,s,wq);


        if(result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(Edge d, Edge s, Queue<Edge> wq) {
        boolean[][] visited = new boolean[n][m];
        Queue<Edge> q = new LinkedList<>();

        q.add(s);
        visited[s.x][s.y] = true;

        while (true) {

            int wqSize = wq.size();
            for (int i = 0; i < wqSize; i++) {
                Edge water = wq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = water.x + dx[j];
                    int ny = water.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        wq.add(new Edge(nx, ny));
                    }
                }
            }

            // --- 고슴도치의 턴 ---
            int size = q.size();
            if (size == 0) { // 고슴도치가 갇혔으면 루프 종료
                return -1;
            }

            for (int i = 0; i < size; i++) {
                Edge curr = q.poll();

                if (curr.x == d.x && curr.y == d.y) {
                    return curr.time;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
                            visited[nx][ny] = true;
                            q.add(new Edge(nx, ny, curr.time + 1));
                        }
                    }
                }
            }
        }
    }
}