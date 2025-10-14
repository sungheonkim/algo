package bj;
import java.util.*;
import java.io.*;
public class bj_9663 {
    private static boolean[][] visited;
    private static int n,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        cnt=0;
        visited=new boolean[n][n];
        //퀸은 대각선 세로선 가로선

        dfs(0);
        System.out.println(cnt);
    }
    private static void dfs(int row){
        if(row==n){
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            //내 체스 둘 수 있는지
            if(possible(row,col)){
                //상대방 체스 놓아주기
                visited[row][col]=true;
                dfs(row+1);
                visited[row][col]=false;
            }
        }
    }
    private static boolean possible(int row,int col){
        //위 row
        for (int i = 0; i <row ; i++) {
            if(visited[i][col]){
                return false;
            }
        }
        // 왼쪽 위 대각선
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) {
                return false;
            }
        }
        //오른쪽 위 대각선
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (visited[i][j]) {
                return false;
            }
        }

        return true;
    }
}
