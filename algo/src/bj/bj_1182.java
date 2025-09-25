package bj;
import java.util.*;
import java.io.*;

public class bj_1182 {
    private static int n,s,cnt;
    private static boolean[] visited;
    private static int[] arr;
    private static List<Integer> num=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        cnt=0;

        //조합
        dfs(0,0);

        //목표가 0이면 공집합 무조건 포함하기 떄문
        if(s==0) cnt--;

        System.out.println(cnt);

    }
    private static void dfs(int depth,int sum) {

        if(depth==n){
            if(sum==s){
                cnt++;
            }
            return;
        }

        //원소를 포함하는 경우
        dfs(depth+1,sum+arr[depth]);

        //아닌 경우
        dfs(depth+1,sum);
    }

}
