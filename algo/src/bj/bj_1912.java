package bj;

import java.io.*;
import java.util.*;

public class bj_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];


        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[n];
        dp[0]=arr[0];
        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
        }

        int result=dp[0];

        for (int i = 1; i < n; i++) {
            result=Math.max(result,dp[i]);
        }

        System.out.println(result);

    }
}
