package bj;
import java.util.*;
import java.io.*;

public class swea_3234 {
    private static int[] arr,tmp;
    private static int n,result;
    private static boolean[] visited;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result=0;
            n=Integer.parseInt(br.readLine());
            arr=new int[n];
            tmp=new int[n];
            visited=new boolean[n];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }

            per(0);
            
            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
    private static void per(int depth){
        if(depth==n){
            dfs(0,0,0);
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                tmp[depth]=arr[i];
                per(depth+1);
                visited[i]=false;
            }
        }
    }
    private static void dfs(int depth,int left,int right){
        if(left<right) {
            return;
        }
        if(depth==n){
            result++;
            return;
        }

        dfs(depth+1,left+tmp[depth],right);
        dfs(depth+1,left,right+tmp[depth]);
    }

}
