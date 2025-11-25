package bj;
import java.util.*;
import java.io.*;

public class bj_17070 {
    private static int n;
    private static int[][] map;
    private static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);

        System.out.println(result);
    }
    // 가로 : 0 , 세로 :1, 대각선 2
    private static void dfs(int x,int y, int dir){
        if(x==n-1 && y==n-1){
            result++;
            return;
        }
        if(dir==0){
            //가로
            if(inRange(x,y+1) && map[x][y+1]==0){
                dfs(x,y+1,0);
            }
            //대각
            if(inRange(x+1,y+1) && map[x+1][y+1]==0 && map[x][y + 1] == 0 && map[x + 1][y] == 0){
                dfs(x+1,y+1,2);
            }
        }
        if(dir==1){
            //세로
            if(inRange(x+1,y) && map[x+1][y]==0){
                dfs(x+1,y,1);
            }
            //대각
            if(inRange(x+1,y+1) && map[x+1][y+1]==0 && map[x][y + 1] == 0 && map[x + 1][y] == 0){
                dfs(x+1,y+1,2);
            }
        }
        if(dir==2){
            //가로
            if(inRange(x,y+1) && map[x][y+1]==0){
                dfs(x,y+1,0);
            }
            //세로
            if(inRange(x+1,y) && map[x+1][y]==0){
                dfs(x+1,y,1);
            }
            //대각
            if(inRange(x+1,y+1) && map[x+1][y+1]==0 && map[x][y + 1] == 0 && map[x + 1][y] == 0){
                dfs(x+1,y+1,2);
            }
        }
    }
    private static boolean inRange(int x,int y){
        return x>=0 && x<n && y>=0 && y<n;
    }
}
