package bj;

import java.util.*;
import java.io.*;
public class bj_11060 {
    private static int n,m,start;
    private static boolean[] visited;
    private static int[] jump;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());

        jump=new int[n];
        visited=new boolean[n];

        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            
            jump[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());


    }
    private static int bfs(){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int max= jump[curr[0]]; // 현재 점프 뛸 수 있는 거리

            for (int i = 1; i <=max ; i++) {


                if(curr[0]+i>=n) continue;

                if(curr[0]+i==n-1) return curr[1]+1;

                if(curr[0]+i<n-1){
                    if(!visited[curr[0]+i]) {
                        q.add(new int[]{curr[0] + i, curr[1] + 1});
                        visited[curr[0] + i] = true;
                    }
                }
                
            }

        }
        return -1;

    }
}
