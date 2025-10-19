package bj;
import java.util.*;
import java.io.*;

public class bj_2529 {
    private static int n;
    private static char[] c;
    private static boolean[] visited;
    private static int[] num;
    private static List<String> resultList=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        c=new char[n];
        visited=new boolean[10];
        num=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for (int i = 0; i <n ; i++) {
            c[i]=st.nextToken().charAt(0);
        }

        //조합 다 만들고 부등호 처리 되면 출력하기?
        dfs(0);

        System.out.println(resultList.get(resultList.size()-1));
        System.out.println(resultList.get(0));
    }
    private static void dfs(int depth){
        if(depth==n+1){
            if(check()){
                StringBuilder sb2=new StringBuilder();
                for (int i = 0; i <n+1; i++) {
                    sb2.append(num[i]);
                }
                resultList.add(sb2.toString());
            }
            return;
        }
        for (int i = 0; i <=9; i++) {
            if(!visited[i]) {
                num[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    private static boolean check(){
        for (int i = 0; i < n; i++) {
            //주어진 부등호와 반대로 되면 false 반환
            if(c[i]=='<'){
                if(num[i]>=num[i+1]) return false;
            }
            else{
                if(num[i]<=num[i+1]) return false;
            }
        }
        return true;
    }
}
