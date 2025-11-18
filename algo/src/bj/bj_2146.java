package bj;
import java.util.*;
import java.io.*;

public class bj_2146 {
    private static int n, num,minDistance;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited=new boolean[n][n];
        num = 1;
        minDistance=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]&&map[i][j] != 0) {
                    bfs(i, j); //한 마을로 묶어주기
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int i = 1; i < num; i++) {
            minBfs(i);// 각 마을별로 다른 마을 거리 구하기
        }
        System.out.println(minDistance);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        map[i][j]=num;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] ==1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                }

            }
        }
        // 구역 다 엮으면 num 증가해서 다르마을
        num++;
    }
    //각 섬끼리 최단 거리 다리 찾기
    private static void minBfs(int i){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedArea=new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <n ; k++) {
                if(map[j][k]==i){
                    q.add(new int[]{j,k,0}); // 거리 관리
                    visitedArea[j][k]=true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();

            //가지치기 거리 : 초과하면 의미없응ㅁ
            if(curr[2]>=minDistance) continue;

            for (int j = 0; j < 4; j++) {
                int nx=curr[0]+dx[j];
                int ny=curr[1]+dy[j];


                //0도 아니고 현재 마을 i도 아니라면
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visitedArea[nx][ny]) {
                    if(map[nx][ny] !=0 &&map[nx][ny] !=i ) {
                        minDistance = Math.min(minDistance, curr[2]);
                        return;
                    }
                    if(map[nx][ny]==0){
                        q.add(new int[]{nx,ny,curr[2]+1});
                        visitedArea[nx][ny]=true;
                    }
                }
            }
        }
    }
}