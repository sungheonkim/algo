package bj;
import java.util.*;
import java.io.*;

public class a_화분 {
    private static int n,p,result;
    private static int[] arr,arr2;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for (int t = 1; t <=T ; t++) {
            result=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            p=Integer.parseInt(st.nextToken());
            arr=new int[n];
            arr2=new int[n];

            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr2[i]=Integer.parseInt(st.nextToken());
            }

            dfs(0,0,0);

            sb.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
    private static void dfs(int depth,int sum,int type){
        //type은 0은 미선택, 1은 바로 이전에 1번 비료, 2는 바로 이전에 2번 비료
        if(depth==n){
            result=Math.max(result,sum);
            return;
        }

        if(type==1) {
            dfs(depth+1,sum+arr[depth]-p,type);
            dfs(depth+1,sum+arr2[depth],2);
        }else if(type==2){
            dfs(depth+1,sum+arr[depth],1);
            dfs(depth+1,sum+arr2[depth]-p,type);
        }else{
            dfs(depth+1,sum+arr[depth],1);
            dfs(depth+1,sum+arr2[depth],2);
        }
    }
}
