package bj;

import java.io.*;
import java.util.*;

public class bj_1354 {
    private static int n,p,q,x,y;
    private static Map<Long,Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        p=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());

        map=new HashMap<>();
        System.out.println(dfs(n));

    }
    private static long dfs(long n){
        if(n<=0) return 1;
        if(map.containsKey(n)){
            return map.get(n);
        }else {
            //map에 없으면 재귀 호출
            long num = dfs(n / p - x) + dfs(n / q - y);
            map.put(n, num);
            return num;
        }

    }
}
