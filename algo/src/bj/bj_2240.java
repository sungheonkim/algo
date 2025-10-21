package bj;
import java.io.*;
import java.util.*;

public class bj_2240 {
    //t초와  자두의 최대 w번의 움직임
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int T= Integer.parseInt(st.nextToken()); //시간
        int W=Integer.parseInt(st.nextToken()); //움직임
        int[] arr=new int[T+1];
        for (int i = 1; i <T+1 ; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        int[][][] dp =new int[T+1][3][W+1];

        if(arr[1]==1){
            dp[1][1][0]=1; //이동 안하고 자두 받음
        }else{
            dp[1][2][1]=1; // 2번으로 이동해서 자두 받음
        }

        for (int t = 2; t <= T ; t++) {
            for (int i = 1; i <=2 ; i++) {
                for (int j = 0; j <= W; j++) {
                    //같은 위치
                    dp[t][i][j]=dp[t-1][i][j];
                    //다른 위치에서 이동옴
                    if(j>0){
                        int other= (i==1) ? 2 :1;
                        dp[t][i][j]=Math.max(dp[t][i][j],dp[t-1][other][j-1]);
                    }
                    //현재 위치에 자두 떨어짐 +1
                    if(arr[t]==i){
                        dp[t][i][j]++;
                    }
                }
            }
        }
        int result=0;
        for (int i = 0; i <=2 ; i++) {
            for (int j = 0; j <=W ; j++) {
                result=Math.max(result,dp[T][i][j]);
            }
        }
        System.out.println(result);
    }

}
