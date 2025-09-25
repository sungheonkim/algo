package bj;
import java.util.*;
import java.io.*;

public class bj_15652 {
    private static int n,m;
    private static int[] num;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        num=new int[m];

        dfs(0,0);
        System.out.println(sb);
    }
    private static void dfs(int depth,int start){
        if(depth==m){
            for (int i = 0; i < m; i++) {
                sb.append(num[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i <n ; i++) {
            num[depth]=i+1;
            dfs(depth+1,i);
        }
    }
}
