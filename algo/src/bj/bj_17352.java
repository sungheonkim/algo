package bj;
import java.io.*;
import java.util.*;
// 이어줄 다리 하나만 찾으면 된다.
public class bj_17352 {
    private static int n;
    private static Set<Integer> set=new HashSet<>();
    public static void main(String[] args) throws IOException{
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         n=Integer.parseInt(br.readLine());


         make();
        for (int i = 0; i <n-2 ; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            union(a,b);
        }
        for (int i = 1; i <=n ; i++) {
            int root=find(i);
            set.add(root);
        }

        StringBuilder sb=new StringBuilder();
        for(Integer num: set){
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }
    private static int[] parents;
    private static void make(){
        parents=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            parents[i]=i;
        }
    }
    private static int find(int a){
        if (parents[a]==a) {
            return a;
        }
        return parents[a]=find(parents[a]);
    }
    private static boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB) return false;

        if(parents[b]<rootA) parents[rootB]=rootA;
        else parents[rootA]=rootB;
        return true;
    }
}

