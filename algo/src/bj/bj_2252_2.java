package bj;
import java.util.*;
import java.io.*;

public class bj_2252_2 {
    private static int n,m;
    private static int[] degree;
    private static List<Integer>[] list;
    private static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        degree=new int[n+1];

        list= new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        //두 학생 키 어떻게 비교하지?
        // a<b 니까 b 시점에서 자기보다 작은 사람들이 몇명인지 관리하자


        for (int i = 0; i < m ; i++) {
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            degree[b]++;
            list[a].add(b);
        }
        bfs();
        System.out.println(sb);
    }
    private static void bfs(){
        Queue<Integer> q=new LinkedList<>();
        //진입차수 0인거 -> 맨앞에 설 것들
        for (int i = 1; i <= n; i++) {
            if(degree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            //큐에서 나오는건 바로 줄 세우기
            int curr=q.poll();
            sb.append(curr).append(' ');
            for (int i = 0; i < list[curr].size() ; i++) {
                int next=list[curr].get(i);
                //curr과 연결되었다는건 curr이 줄에 들어갔기 때문에 next의 진입차수 --
                degree[next]--;
                if(degree[next]==0) q.add(next);
            }
        }
    }
}
