package bj;

import java.io.*;
import java.util.*;

public class bj_17136 {
    private static int[][] map = new int[10][10];
    // 1. 배열 크기를 6으로 수정 (인덱스 1~5 사용)
    private static int[] paperCnt = {0, 5, 5, 5, 5, 5};
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // ... main 메서드는 동일 ...
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 10 ; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);

        if(minResult==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minResult);
        }
    }

    private static void dfs(int x, int y, int cnt) {
        // 가지치기
        if (cnt >= minResult) {
            return;
        }

        // 2. 종료 조건 수정: x가 10이면 모든 탐색 완료
        if (x == 10) {
            minResult = Math.min(minResult, cnt);
            return;
        }

        // 3. 탐색 흐름 수정: 다음 좌표를 미리 계산
        int nextX = x;
        int nextY = y + 1;
        if (nextY == 10) {
            nextX = x + 1;
            nextY = 0;
        }

        if (map[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paperCnt[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0);
                    paperCnt[size]--;

                    // 다음 탐색은 미리 계산해둔 nextX, nextY로!
                    dfs(nextX, nextY, cnt + 1);

                    attach(x, y, size, 1);
                    paperCnt[size]++;
                }
            }
        } else { // 현재 칸이 0이면 바로 다음 칸으로 이동
            dfs(nextX, nextY, cnt);
        }
    }

    // attach, canAttach 메서드는 수정할 필요 없음
    private static void attach(int x,int y,int size,int state){
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                map[i][j]=state;
            }
        }
    }
    private static boolean canAttach(int x,int y, int size){
        if(x+size>10 ||y+size>10){
            return false;
        }
        for (int i = x; i < x+size; i++) {
            for (int j = y; j <y+size ; j++) {
                if(map[i][j]==0) return false;
            }
        }
        return true;
    }
}