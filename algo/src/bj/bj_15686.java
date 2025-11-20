package bj;
import java.io.*;
import java.util.*;

public class bj_15686 {
    static class Edge{
        int x,y;
        public Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static int n,m,result;
    private static List<Edge> home=new ArrayList<>();
    private static List<Edge> chicken=new ArrayList<>();
    private static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        result=Integer.MAX_VALUE;


        for (int i = 0; i <n ; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j <n ; j++) {
                int curr=Integer.parseInt(st.nextToken());
                if(curr==1) {
                    home.add(new Edge(i, j));
                }else if(curr==2){
                    chicken.add(new Edge(i,j));
                }
            }
        }
        isSelected=new boolean[chicken.size()];
        //1. 폐업시킬 조합을 먼저 구하고, 2. 맨허튼 거리를 구해서 합을 구하자, 3. 치킨 거리 가장 작은거 판단
        dfs(0,0);

        System.out.println(result);
    }
    private static void dfs(int depth,int cnt){
        if(cnt==m){
            dis();
            return;
        }
        if(depth==chicken.size()){
            return;
        }

        //중복 없는 조합 만들어야함
        isSelected[depth]=true;
        dfs(depth+1,cnt+1);
        isSelected[depth]=false;
        dfs(depth+1,cnt);
    }
    private static void dis(){
        int sum=0; // 총거리
        for (int i = 0; i < home.size(); i++) {
            int min=Integer.MAX_VALUE; //집에서 젤 가까운 치킨집 찾기
            for (int j = 0; j < chicken.size(); j++) {
                if(isSelected[j]){
                    int man=Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y);
                    min=Math.min(min,man);
                }
            }
            sum+=min;
        }
        result=Math.min(sum,result);
    }

}
