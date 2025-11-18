package bj;
import java.util.*;
import java.io.*;
// 5 2
// 1 4 4 8 1   -> 출력 9인거 보면 가장 오래 걸리는거 부터 꽂는건가?

public class bj_23843 {
    
    static class Con implements Comparable<Con>{
        int end;
        public Con(int time,int charge){
            this.end=time+charge;
        }
        @Override
        public int compareTo(Con o){
            return this.end-o.end;
        }
    }
    static class Charge implements Comparable<Charge>{
        int time;
        public Charge(int time){
            this.time=time;
        }
        @Override
        public int compareTo(Charge o){
            return o.time-this.time;
        }
    }
    private static int n,m;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        PriorityQueue<Con> con=new PriorityQueue<>();
        PriorityQueue<Charge> charge=new PriorityQueue<>();

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            charge.add(new Charge(Integer.parseInt(st.nextToken())));
        }
        int time=0;
        while(!charge.isEmpty()){
            if(!con.isEmpty()&&con.peek().end==time){
                //제일 먼저 종료되는 것의 시간이 현재 시간과 같다면
                con.poll();
            }
            if(con.size()<m){
                int curr=charge.poll().time;
                con.add(new Con(time,curr));// 종료 시간 넘겨주기
            }
            time++;
        }
        System.out.println(time-1);





    }
}

