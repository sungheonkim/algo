import java.util.*;
class Solution {
    private static List<Integer> list=new ArrayList<>();
    private static boolean[][] visited;
    private static int[] dx={1,-1,0,0};
    private static int[] dy={0,0,-1,1};
    private static int sum=0,n,m;
    public int[] solution(String[] maps) {
        int[] answer ;
        n=maps.length;
        m=maps[0].length();

        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(maps[i].charAt(j)!='X'){
                        sum=0;
                        dfs(i,j,maps);
                        list.add(sum);
                    }
                }
            }
        }


        if(list.isEmpty()){
            return new int[]{-1};
        }

        Collections.sort(list);
        answer=new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
    private static void dfs(int x,int y,String[] maps){

        visited[x][y]=true;
        sum+=maps[x].charAt(y)-'0';

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0||nx>=n||ny<0||ny>=m) continue;
            if(visited[nx][ny]) continue;

            if(maps[nx].charAt(ny)!='X'){
                dfs(nx,ny,maps);
            }
        }
    }
}