package bj;
import java.util.*;
import java.io.*;

public class bj_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] time=new int[n+1];
        int[] price=new int[n+1];
        int[] dp=new int[n+2];

        for (int i = 1; i < n+1; i++) {
            st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            price[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >=1 ; i--) {

            if(i+time[i]<=n+1){
                dp[i]=Math.max(dp[i+1],dp[i+time[i]]+price[i]);
            }else dp[i]=dp[i+1];
        }
        System.out.println(dp[1]);
    }
}
