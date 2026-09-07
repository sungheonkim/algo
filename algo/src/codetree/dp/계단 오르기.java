import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp=new int[1000];


        // 2 Or 3 씩만 올라감
        dp[0]=1;
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;

        for(int i=4;i<n+1;i++){
            dp[i]=(dp[i-2]+dp[i-3])%10007;
        }
        System.out.println(dp[n]);

        // Please write your code here.
    }
}