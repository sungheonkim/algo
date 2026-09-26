import java.util.*;
import java.io.*;

public class Main {
    private static int n,k,r1,r2,c1,c2;
    private static int[][] grid;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken())-1;
        c1 = Integer.parseInt(st.nextToken())-1;
        st=new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken())-1;
        c2 = Integer.parseInt(st.nextToken())-1;

        int result=bfs();
        System.out.println(result);

        // Please write your code here.
    }
    private static boolean inRange(int x,int y){
        return x>=0 &&x<n &&y>=0 &&y<n;
    }
    private static int bfs(){
        Queue<int[]> q=new LinkedList<>();
        boolean[][][] visited=new boolean[n][n][k+1];

        q.add(new int[]{r1,c1,k,0});
        visited[r1][c1][k]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            if(curr[0]==r2&&curr[1]==c2) return curr[3];

            for(int i=0;i<4;i++){
                int nx= curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(!inRange(nx,ny)) continue;
                if(visited[nx][ny][curr[2]]) continue;


                if(grid[nx][ny]==1 && curr[2]>0){
                    q.add(new int[]{nx,ny,curr[2]-1,curr[3]+1});
                    visited[nx][ny][curr[2]-1]=true;
                }else if(grid[nx][ny]==0){
                    q.add(new int[]{nx,ny,curr[2],curr[3]+1});
                    visited[nx][ny][curr[2]]=true;
                }
            }
        }
        return -1;

    }
}