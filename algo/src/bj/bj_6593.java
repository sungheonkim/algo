package bj;
import java.util.*;
import java.io.*;
public class bj_6593 {
    private static Character[][][] map;
    private static boolean[][][] visited;
    private static StringBuilder sb=new StringBuilder();
    private static int l,r,c;
    private static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 0,0,0 입력받을떄까지 계속
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            map = new Character[l][r][c];
            start = new int[3];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start = new int[]{i, j, k};
                        }
                    }
                }
                // 각 층 사이의 빈 줄 처리
                if (i < l - 1) {
                    br.readLine();
                }
            }

            bfs();
            sb.append('\n');

            br.readLine();
        }
        System.out.print(sb);
    }

    private static void bfs(){
        int[] point=start;
        int[] dl = {0, 0, 0, 0, 1, -1};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};

        Queue<int[]> q=new LinkedList<>();
        visited = new boolean[l][r][c];
        q.add(new int[]{point[0],point[1],point[2],0});
        visited[point[0]][point[1]][point[2]]=true;

        while (!q.isEmpty()){
            int[] curr= q.poll();

            //종료조건
            if (map[curr[0]][curr[1]][curr[2]] == 'E') {
                sb.append("Escaped in ").append(curr[3]).append(" minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int newL = curr[0] + dl[i];
                int newX = curr[1] + dx[i];
                int newY = curr[2] + dy[i];
                if (canGo(newL, newX, newY)) {
                    if (!visited[newL][newX][newY] && map[newL][newX][newY] != '#') {
                        visited[newL][newX][newY] = true;
                        q.add(new int[]{newL, newX, newY, curr[3] + 1});
                    }
                }
            }
        }
        sb.append("Trapped!");
    }

    private static boolean canGo(int depth,int x, int y){
        return depth>=0 && depth< l && x>=0 &&x<r && y>=0 && y < c;
    }
}