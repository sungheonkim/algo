import java.util.*;
import java.io.*;

public class Main {
    private static int n,m;
    private static int INF=(int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] dist=new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dist[i][j]= i==j ? 0: INF;
            }
        }

        for(int i = 0; i < m; i++){
            st=new StringTokenizer(br.readLine());
            int from,to,cost;

            from=Integer.parseInt(st.nextToken());
            to=Integer.parseInt(st.nextToken());
            cost=Integer.parseInt(st.nextToken());

            if(dist[from][to]>cost) dist[from][to]=cost;

        }

        for(int k=0;k<n+1;k++){
            for(int i=0;i<n+1;i++){
                for(int j=0;j<n+1;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(dist[i][j]==INF){
                    sb.append(-1);
                }else{
                    sb.append(dist[i][j]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        // Please write your code here.
    }
}