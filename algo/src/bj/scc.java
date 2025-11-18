package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class scc {

    static int V, E;
    static List<Integer>[] adj;
    static int[] dfsn; // 방문하는 노드의 순서번호
    static int sccCounter, nodeCounter;
    static ArrayList<ArrayList<Integer>> sccList;
    static Stack<Integer> stack;
    static boolean[] finished;
    static int[] sccId;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 변수 초기화
        adj = new ArrayList[V];
        dfsn = new int[V];
        sccList = new ArrayList<>();
        sccCounter = 0;
        nodeCounter = 0;
        stack = new Stack();
        finished = new boolean[V];
        sccId = new int[V];

        // 인접 리스트 초기화
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // 그래프 입력
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            adj[A].add(B);
        }

        // 모등 정점에 대해 DFS 수행
        for(int i = 0; i < V; i++) {
            if(dfsn[i] == 0) {
                dfs(i);
            }
        }

        // 출력
        System.out.println(sccCounter);

        for(ArrayList<Integer> scc : sccList) {
            Collections.sort(scc);
        }

        Collections.sort(sccList, (sccA, sccB) -> {
            return Integer.compare(sccA.get(0), sccB.get(0));
        });

        for(ArrayList<Integer> scc : sccList) {
            for(int node : scc) {
                System.out.print((node+1) + " ");
            }
            System.out.println("-1");
        }
    }

    private static int dfs(int cur) {
        dfsn[cur] = ++nodeCounter;
        stack.push(cur);

        int result = dfsn[cur];

        for(int next : adj[cur]) {
            if(dfsn[next] == 0) {
                result = Math.min(result, dfs(next));
            } else if(!finished[next]) {
                result = Math.min(result, dfsn[next]);
            }
        }

        if(result == dfsn[cur]) {
            ArrayList<Integer> curList = new ArrayList<>();

            while(true) {
                int t = stack.pop();
                finished[t] = true;
                curList.add(t);
                sccId[t] = sccCounter;

                if(t == cur) break;
            }

            sccList.add(curList);
            sccCounter++;
        }
        return result;
    }
}
