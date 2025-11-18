package bj;
import java.util.*;
import java.io.*;

public class bj_11000 {
    static class Lecture implements Comparable<Lecture>{
        int start,end;

        public Lecture(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public int compareTo(Lecture o){
            return this.start-o.start;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq=new PriorityQueue<>();
        PriorityQueue<Integer> room=new PriorityQueue<>(); //끝나는시간으로 강의실 관리

        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int maxRoom=0;

        while(!pq.isEmpty()){
            // 종료되는 강의 먼저 확인하기
            //현재 강의 시작 시간과 가장 먼저 끝나는 강의실 비교하기
            Lecture curr=pq.poll();
            //2.
            if(!room.isEmpty()&&room.peek()<=curr.start){ // 시작 시간보다 강의실 끄타는게 지나면 강의가 이미 끝나서
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
