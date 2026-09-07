import java.util.*;
import java.io.*;

//각각 위치에 어떤 폭탄을 놓을지 -> 백트래킹
//폭탄 터트려서 갯수 세기
// 최대치 갱신
public class Main {
    private static int n,ans=0;
    private static int[][] map;
    private static List<Edge> list=new ArrayList<>();
    private static List<Integer> isSelected=new ArrayList<>();
    private static int[][][] type= {
            {//1번 타입
                    {-2,-1,0,1,2},{0,0,0,0,0}
            },{//2번 타입
            {-1,1,0,0,0},{0,0,0,1,-1}
    },{//3번 타입
            {-1,-1,0,1,1},{1,-1,0,1,-1}
    }
    };
    static class Edge{
        int x,y;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());


        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    list.add(new Edge(i,j));
                }
            }
        }
        per(0);
        System.out.println(ans);
        // Please write your code here.
    }
    private static int bomb(){
        boolean[][] visited=new boolean[n][n];
        int cnt=0;
        for(int i=0;i<list.size();i++){
            Edge curr=list.get(i);
            int currType=isSelected.get(i);

            for(int j=0;j<5;j++){
                int nx=curr.x+type[currType][0][j];
                int ny=curr.y+type[currType][1][j];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;

                if(visited[nx][ny]) continue;

                cnt++;
                visited[nx][ny]=true;
            }
        }
        return cnt;
    }
    private static void per(int size){
        if(size==list.size()){
            int cnt=bomb();

            ans=Math.max(ans,cnt);
            return;
        }

        for(int i=0;i<3;i++){
            isSelected.add(i);
            per(size+1);
            isSelected.remove(isSelected.size()-1);
        }

    }
}

