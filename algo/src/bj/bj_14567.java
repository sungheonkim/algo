package bj;

import java.util.*;
import java.io.*;

public class bj_14567 {
    private static int n,m;
    private static int[] degree;
    private static int[] rank;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        degree=new int[n+1];
        list=new ArrayList[n+1];
        rank=new int[n+1];

        for (int i = 0; i <n+1; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            degree[b]++;
            list[a].add(b);
        }
        bfs();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=n; i++) {
            sb.append(rank[i]).append(' ');
        }
        System.out.println(sb);
    }
    private static void bfs(){
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(degree[i]==0){
                q.add(i);
            }
        }
        // depth를 통해 학기를 관리해주자
        int depth=1;
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int curr=q.poll();
                rank[curr]=depth;
                for (int j = 0; j < list[curr].size(); j++) {
                    int next=list[curr].get(j);
                    degree[next]--;
                    if(degree[next]==0) q.add(next);
                }
            }
            depth++;
        }
    }

}
