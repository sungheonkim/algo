package bj;

import java.util.*;
import java.io.*;

public class bj_18656{ // 클래스 이름은 Main으로 제출해야 할 수 있습니다.
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> home = new ArrayList<>();
    private static List<Point> store = new ArrayList<>();
    private static int n, m, storeNum, result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) home.add(new Point(i, j));
                else if (num == 2) store.add(new Point(i, j));
            }
        }

        storeNum = store.size();
        visited = new boolean[storeNum];

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int cnt) {
        if (depth == storeNum) {

            if (cnt >= 1 && cnt <= m) {
                distance();
            }
            return;
        }

        // 가지치기
        if (cnt > m) {
            return;
        }

        visited[depth] = true;
        dfs(depth + 1, cnt + 1); // 현재 치킨집 포함

        visited[depth] = false;
        dfs(depth + 1, cnt); // 현재 치킨집 미포함
    }

    private static void distance() {
        int total = 0;

        for (int i = 0; i < home.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < store.size(); j++) {
                if (visited[j]) {
                    int dis = Math.abs(store.get(j).x - home.get(i).x)
                            + Math.abs(store.get(j).y - home.get(i).y);
                    min = Math.min(min, dis);
                }
            }
            total += min;
        }
        result = Math.min(result, total);
    }
}
