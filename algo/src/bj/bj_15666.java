package bj;

import java.io.*;
import java.util.*;

public class bj_15666 {
    private static int[] arr,num;
    private static int n,m;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        num=new int[m];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    private static void dfs(int depth,int start){
        if(depth==m){
            for (int i = 0; i <m ; i++) {
                sb.append(num[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int prev=0;
        for (int i = start; i < n; i++) {
            if(prev!=arr[i]){
                num[depth]=arr[i];
                prev=arr[i];
                dfs(depth+1,i);
            }

        }
    }
}
