package bj;
import java.util.*;
import java.io.*;

public class bj_15664 {
    private static int n,m;
    private static int[] num,arr;
    private static boolean[] visited;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n];
        num=new int[m];
        visited=new boolean[n];

        st=new StringTokenizer(br.readLine());

        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        //사전순
        Arrays.sort(arr);

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
        int prev=0;
        for (int i = start; i <n ; i++) {
            if(!visited[i]&&prev!=arr[i]) {
                visited[i]=true;
                num[depth] = arr[i];
                prev=arr[i];
                dfs(depth + 1,i+1);
                visited[i]=false;
            }
        }
    }
}
