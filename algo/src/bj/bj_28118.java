package bj;
import java.util.*;
import java.io.*;

public class bj_28118 {
    static class Edge{
        int a,b;
        public Edge(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    private static int[] parents;
    private static int n,m;
    private static List<Edge> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b));
        }
        make();

        int cnt=0;
        for(Edge edgeList : list){
            if(union(edgeList.a,edgeList.b)) {
            cnt++;
            if(cnt==n-1) break;
            }// 이미 다 연결임
            // 최소비용 뭔가 구하는게
        }

        System.out.println(n-1-cnt);

    }
    private static void make(){
        parents=new int[n+1];
        for (int i = 1; i <= n; i++) {
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
        if(aRoot==bRoot) return false; // 이미 같은 그룹

        if (bRoot>aRoot) parents[bRoot]=aRoot;
        else parents[aRoot] =bRoot;
        return true;
    }




}
