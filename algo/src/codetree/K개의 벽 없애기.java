import java.util.*;
import java.io.*;

public class Main {
    private static int n,k,r1,r2,c1,c2;
    private static int[][] grid;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());

        r1=Integer.parseInt(st.nextToken())-1;
        c1=Integer.parseInt(st.nextToken())-1;

        st=new StringTokenizer(br.readLine());

        r2=Integer.parseInt(st.nextToken())-1;
        c2=Integer.parseInt(st.nextToken())-1;


        System.out.println(bfs());


    }
    private static int bfs(){
        int[] dx=new int[]{1,-1,0,0};
        int[] dy=new int[]{0,0,1,-1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited=new boolean[n][n][k+1];

        q.add(new int[]{r1,c1,0,k});
        visited[r1][c1][k]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            if(curr[0]==r2&&curr[1]==c2){
                return curr[2];
            }

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;
                if(visited[nx][ny][curr[3]]) continue;
                if(grid[nx][ny]==1){
                    if(curr[3]>=1){
                        q.add(new int[]{nx,ny,curr[2]+1,curr[3]-1});
                        visited[nx][ny][curr[3]-1]=true;
                    }
                }else{
                    q.add(new int[]{nx,ny,curr[2]+1,curr[3]});
                    visited[nx][ny][curr[3]]=true;
                }
            }

        }

        return -1;
    }
}