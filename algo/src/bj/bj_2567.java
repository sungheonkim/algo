package bj;
import java.util.*;
import java.io.*;

public class bj_2567 {
    private static int n;
    private static int[][] map=new int[102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        int result=0;
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            for (int j = x+1; j < x+11; j++) {
                for (int k = y+1; k <y+11 ; k++) {
                    map[j][k]=1;
                }
            }
        }


        for (int i = 1; i <101 ; i++) {
            for (int j = 1; j < 101; j++) {

                if(map[i][j]==1) {
                    if (map[i][j + 1] == 0) result++;
                    if (map[i][j - 1] == 0) result++;
                    if (map[i + 1][j] == 0) result++;
                    if (map[i - 1][j] == 0) result++;
                }
            }

        }
        //전체 큰 사각형에서 나머지 빼게 해야될듯?
        System.out.println(result);
    }
}
