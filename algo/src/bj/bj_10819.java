package bj;
import java.util.*;
import java.io.*;

public class bj_10819 {
    private static int n,max;
    private static int[] arr,num;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[n];
        num=new int[n]; // 새로 조합된 배열
        visited=new boolean[n];
        max=0;

        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
    private static void dfs(int depth){
        if(depth==n){
            result();
            return;
        }
        //permutation
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }
    //새로 조합된 배열에서 식 계산하고 최대값 처리
    private static void result(){
        int sum=0;
        for (int i = 0; i < n-1; i++) {
            sum+=Math.abs(num[i]-num[i+1]);
        }
        max=Math.max(max,sum);

    }
}
