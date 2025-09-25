package bj;
import java.util.*;
import java.io.*;

public class bj_15650 {
    private static int n,m;
    private static boolean[] visited;
    private static int[] result;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        visited=new boolean[n];
        result=new int[m];

        dfs(0,0);
        System.out.println(sb);
    }
    private static void dfs(int depth,int start){
        if(depth==m){
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
                result[depth] = i + 1;
                dfs(depth + 1, i + 1);


        }

    }
}

