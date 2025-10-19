package bj;
import java.util.*;
import java.io.*;

public class bj_14888 {
    private static int n,plus,minus,mul,div,min,max;
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        num=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        plus=Integer.parseInt(st.nextToken());
        minus=Integer.parseInt(st.nextToken());
        mul=Integer.parseInt(st.nextToken());
        div=Integer.parseInt(st.nextToken());

        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;

        dfs(1,num[0],plus,minus,mul,div);

        System.out.println(max);
        System.out.println(min);


    }
    // dfs에서 각 연산자의 사용 횟수를 관리 해줘야함
    private static void dfs(int depth,int sum,int plusCnt,int minusCnt,int mulCnt,int divCnt){
        if(plusCnt==-1){
            return;
        }
        if(minusCnt==-1){
            return;
        }
        if(mulCnt==-1){
            return;
        }
        if(divCnt==-1){
            return;
        }
        //여기까지는 연산자를 초과로 쓰는거 방지

        //모든 연산자 횟수가 0일 때가 올바르게 도달
        if(plusCnt==0&&minusCnt==0&&mulCnt==0&&divCnt==0){
            min=Math.min(sum,min);
            max=Math.max(sum,max);
            return;
        }

        dfs(depth+1,sum+num[depth],plusCnt-1,minusCnt,mulCnt,divCnt);
        dfs(depth+1,sum-num[depth],plusCnt,minusCnt-1,mulCnt,divCnt);
        dfs(depth+1,sum*num[depth],plusCnt,minusCnt,mulCnt-1,divCnt);
        dfs(depth+1,sum/num[depth],plusCnt,minusCnt,mulCnt,divCnt-1);

    }
}
