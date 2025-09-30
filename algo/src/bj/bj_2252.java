package bj;
import java.io.*;
import java.util.*;

public class bj_2252 {
    private static int n,m;
    private static List<Integer>[] graph;
    private static int[] degree;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        degree =new int[n+1];
        graph=new ArrayList[n+1];
        for (int i = 0; i <n+1 ; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            degree[to]++; //차수 증가
            graph[from].add(to);
        }
        bfs();
        System.out.println(sb);
    }
    private static void bfs(){

        Queue<Integer> q=new LinkedList<>();

        //진입차수 0인거 다 넣기
        for (int i = 1; i <n+1 ; i++) {
            if(degree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr= q.poll();
            sb.append(curr).append(' ');
            for (int i = 0; i < graph[curr].size() ; i++) {
                int tmp=graph[curr].get(i);
                degree[tmp]--; // 한번 꺼냇으니깐 차수 하나 내려주기
                //차수 0되면 큐 에 넣기
                if(degree[tmp]==0){
                    q.add(tmp);
                }
            }

        }
    }
}
