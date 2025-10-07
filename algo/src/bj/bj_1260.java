package bj;


import java.util.*;
import java.io.*;
public class bj_1260 {
    private static int n,m,v;
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static StringBuilder sb1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        v=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        visited=new boolean[n+1];
        sb1=new StringBuilder();

        for (int i = 0; i <=n ; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i <m ; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            //양방향넣기
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 1; i <=n ; i++) {
            Collections.sort(list[i]);
        }


        dfs(v);
        sb1.append('\n');
        visited=new boolean[n+1];
        bfs(v);
        System.out.println(sb1);

    }
    private static void dfs(int v){
        visited[v]=true;
        sb1.append(v).append(' ');


        for (int i = 0; i <list[v].size() ; i++) {
            int tmp=list[v].get(i);
            if(!visited[tmp]){
                dfs(tmp);
            }
        }
    }
    private static void bfs(int v){
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        visited[v]=true;
        sb1.append(v).append(' ');

        while (!q.isEmpty()){
            int curr=q.poll();
            for (int i = 0; i <list[curr].size() ; i++) {
                int tmp=list[curr].get(i);
                if(!visited[tmp]){
                    q.add(tmp);
                    visited[tmp]=true;
                    sb1.append(tmp).append(' ');
                }
            }
        }
    }
}
