package bj;

import java.util.*;
import java.io.*;
public class bj_16562 {
    private static int n,m,k;
    private static int[] fee;
    private static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        fee=new int[n+1];

        init();

        st=new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            fee[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            union(from,to);//친구 맺기 (그룹들 생김)
        }

        int result=0;

        //각 그룹에서 최소 친구비 계산
        for (int i = 1; i <=n ; i++) {
            int root=find(i); // 그룹의 루트
            int min=0;
            if(map.containsKey(root)){
                // 이미 처리했던 루트면 최소값 찾기
                min=Math.min(map.get(root),fee[i]);
            }else{
                min=Math.min(Integer.MAX_VALUE,fee[i]);
            }
            map.put(root,min);
        }
        for(int cost : map.values()){
            result+=cost;
        }

        if(result>k){
            //비용 이슈
            System.out.println("Oh no");
            return;
        }
        System.out.println(result);

    }
    private static int[] parents;
    private static void init(){
        parents=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i]=i;
        }
    }
    private static int find(int a){
        if(parents[a]==a) return a;
        return parents[a]= find(parents[a]);
    }
    private static boolean union(int a,int b){
        int aRoot=find(a);
        int bRoot=find(b);
        if(aRoot==bRoot) return false;

        if(aRoot>bRoot) parents[bRoot]=aRoot;
        else parents[aRoot]=bRoot;
        return true;
    }
}
