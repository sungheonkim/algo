package bj;
import java.io.*;
import java.util.*;

public class bj_15811 {
    private static List<Character> alp;
    private static Map<Character,Integer> map=new HashMap<>();
    private static String a,b,c;
    private static int n;
    private static boolean[] visited=new boolean[10];
    private static boolean flag=false;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        a=st.nextToken();
        b=st.nextToken();
        c=st.nextToken();

        Set<Character> set=new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            char tmp=a.charAt(i);
            set.add(tmp);
        }
        for (int i = 0; i < b.length(); i++) {
            char tmp=b.charAt(i);
            set.add(tmp);
        }
        for (int i = 0; i < c.length(); i++) {
            char tmp=c.charAt(i);
            set.add(tmp);
        }
        alp=new ArrayList<>(set);
        n=alp.size();

        //dfs로 알파벳 숫자 할당해서 조합 만들기
        dfs(0);
        //숫자로 바꿔서 계산하는데 맨 앞자리 0되면 안됨
        if(!flag) System.out.println("NO");


    }
    private static void dfs(int depth){
        if(flag) return; // 이미 답 찾은 상태
        if(depth==n){
            //맨앞자리 0일때
            if(map.get(a.charAt(0))==0) return;
            if(map.get(b.charAt(0))==0) return;
            if(map.get(c.charAt(0))==0) return;

            long numA=toNum(a);
            long numB=toNum(b);
            long numC=toNum(c);

            if(numA+numB==numC){
                System.out.println("YES");
                flag=true;
            }
            return;

        }

        char target=alp.get(depth);
        for (int i = 0; i <=9 ; i++) {
            if(!visited[i]){
                //i라는 숫자를 아직 사용하지 않았다면
                visited[i]=true;
                map.put(target,i);
                dfs(depth+1);
                visited[i]=false;
            }
        }

    }
    private static long toNum(String s){
        long value=0;
        for (int i = 0; i < s.length(); i++) {
            value=value*10+map.get(s.charAt(i));
        }
        return value;
    }
}
