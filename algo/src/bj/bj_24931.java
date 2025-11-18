package bj;
import java.io.*;
import java.util.*;
public class bj_24931 {
    private static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        make();

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int[] c= new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i]=Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        for (int i = 0; i < n-1; i++) {
            int currRoot=find(c[i]);
            int nextRoot=find(c[i+1]);
            if(currRoot!=nextRoot) cnt++;
        }
        System.out.println(cnt);
    }
    private static int[] parents;
    private static void make(){
        parents=new int[n+1];
        for (int i =1; i <=n ; i++) {
            parents[i]=i;
        }
    }
    private static int find(int a){
        if(parents[a]==a) return a;
        return parents[a]=find(parents[a]);
    }
    private static boolean union(int a,int b){
        int aRoot=find(a);
        int bRoot=find(b);
        if(aRoot==bRoot) return true;
        if(parents[bRoot]<aRoot) parents[bRoot]=aRoot;
        else parents[aRoot]=bRoot;
        return true;
    }

}
