package bj;
import java.util.*;
import java.io.*;

public class bj_1374 {
    static class Lecture implements Comparable<Lecture>{

        int start;
        int end;
        public Lecture(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public int compareTo(Lecture o){
            return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //동시 두개 강의 진행 불가능
        // 종료시간 시작시간 겹쳐도됨 (동시간에 처리 가능)
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq=new PriorityQueue<>();
        PriorityQueue<Integer> room=new PriorityQueue<>();// 사용중인 강의실 종료시간으로 관리하기

        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            pq.add(new Lecture(b,c));
        }

        int maxRoom=0;

        while(!pq.isEmpty()){
            // 종료되는 강의 먼저 확인하기
            //현재 강의 시작 시간과 가장 먼저 끝나는 강의실 비교하기
            Lecture curr=pq.poll();
            if(!room.isEmpty()&&room.peek()<=curr.start){
                room.poll();
            }
            //새로운 강의 종료 시간 강의실에 넣어주기
            room.add(curr.end);

            //현재 룸갯수과 최대 갱신
            maxRoom=Math.max(room.size(),maxRoom);
        }
        System.out.println(maxRoom);

    }
}
