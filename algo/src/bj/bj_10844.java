package bj;
import java.util.*;
import java.io.*;
public class bj_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int mod= 1_000_000_000;
        long[][] dp=new long[n+1][10];

        //초기값
        for (int i = 1; i <=9 ; i++) {
           dp[1][i]=1;
        }


        for (int i = 2; i <=n; i++) {
            for (int j = 0; j <10 ; j++) {
                if(j==0){
                    //0은 1에서만 온다
                    dp[i][j]=dp[i-1][1]%mod;
                }else if(j==9){
                    dp[i][j]=dp[i-1][8]%mod;
                }else{
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
                }
            }
        }
        long result=0;
        for (int i = 0; i <=9 ; i++) {
            result=(result+dp[n][i])%mod;
        }

        System.out.println(result);
    }
}
