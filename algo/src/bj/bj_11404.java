package bj;
import java.util.*;
import java.io.*;
public class bj_11404 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        //기본 구조
        int[][] cost=new int[n+1][n+1];
        int INF=10000001;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i!=j) cost[i][j]=INF;
                else cost[i][j]=0;
            }
        }

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());

            int from=Integer.parseInt(st.nextToken());// 출발
            int to=Integer.parseInt(st.nextToken());//도착
            int c=Integer.parseInt(st.nextToken());//비용
            cost[from][to]=Math.min(cost[from][to],c);
        }

        //플로이드 최단
        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <=n ; j++) {
                    if(cost[i][j]>cost[i][k]+cost[k][j]){
                        cost[i][j]=cost[i][k]+cost[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(cost[i][j]==INF) sb.append("0 ");
                else sb.append(cost[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
