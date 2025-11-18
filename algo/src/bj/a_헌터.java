package bj;
import java.util.*;
import java.io.*;

public class a_헌터 {
    private static int n,min;
    private static int[][] map;
    static class Edge{
        int x,y;
        boolean visited;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
            this.visited=false;
        }
    }
    private static Map<Integer,Edge> list;
    private static List<Integer> num,tmp; //순열로 방문 순서 만들기 위해
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        for (int t = 1; t <=T ; t++) {
            n=Integer.parseInt(br.readLine());
            map=new int[n][n];
            min=Integer.MAX_VALUE;
            list=new HashMap<>();
            num=new ArrayList<>();
            tmp=new ArrayList<>();

            //몬스터는 양수 고객 음수 둘이 대응됨
            for (int i = 0; i < n; i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                for (int j = 0; j <n ; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    if(map[i][j]!=0){
                        //몬스터 또는 사람 기록
                        list.put(map[i][j],new Edge(i,j));
                        num.add(map[i][j]);
                    }
                }
            }
            visited=new boolean[num.size()];
            per(0);
            sb.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
    }
    private static void result(){
        for(Edge edge : list.values()) {
            edge.visited = false;
        }
        int total=0;
        int currX=0;
        int currY=0;
        for (int i = 0; i <tmp.size() ; i++) {
            int type=tmp.get(i);
            Edge currEdge=list.get(type);
            if(type<0){
                int mon=type * -1; // 양수로 대응하는 몬스터 방문햇는지
                if(!list.get(mon).visited) {
                    return; //해당 순열로는 불가능
                }
            }
            //예외사항 다 처리했으니
            total+=Math.abs(currX-currEdge.x)+Math.abs(currY-currEdge.y);
            currEdge.visited=true;

            currX=currEdge.x;
            currY=currEdge.y;
        }
        min=Math.min(min,total);
    }
    private static void per(int depth){
        if(depth==num.size()){
            result();
            return;
        }

        for (int i = 0; i < num.size(); i++) {
            if(!visited[i]){
                visited[i]=true;
                tmp.add(num.get(i));
                per(depth+1);
                tmp.remove(tmp.size()-1);
                visited[i]=false;
            }
        }
    }

}
