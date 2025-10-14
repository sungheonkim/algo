package bj;
import java.util.*;
import java.io.*;

public class bj_1182 {
    private static int n,s,cnt;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        arr=new int[n];
        cnt=0;

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0,false);
        System.out.println(cnt);

    }
    //부분순열-> 각 원소 선택하냐 마냐 2^n
    private static void dfs(int depth,int sum,boolean flag) {
        // 선택여부 판단 완료
        if(depth==n){
            //System.out.println(sum);  //아무것도 선택하지 않을 때 0되는데 공집합은 부분수열 아님
            if(flag&&sum==s){
                cnt++;
            }
            return;
        }

        //선택함
        dfs(depth+1,sum+arr[depth],true);
        //선택안함
        dfs(depth+1,sum,flag);
    }

}
