package bj;

import java.util.*;
import java.io.*;
public class bj_17182 {
    private static int n,k;
    private static int[][] time;
    private static boolean[] visited;
    private static int result=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        time=new int[n][n];
        visited=new boolean[n];

        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                time[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        // 플로이드로 이동 경로 최적화

        for (int k = 0; k < n; k++) {
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    time[i][j]=Math.min(time[i][j],time[i][k]+time[k][j]);
                }
            }
        }

        visited[k]=true;
        dfs(k,0,1);
        System.out.println(result);

    }
    private static void dfs(int curr,int sumTime,int cnt){
        if(cnt==n){
            result=Math.min(result,sumTime);
            return;
        }
        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                visited[i]=true;
                dfs(i,sumTime+time[curr][i],cnt+1);
                visited[i]=false;
            }
        }
    }

}
