import java.util.*;

//모든 디스크 대기큐, 소요시간 짧은것, 요청 시각 빠른것, 작업 번호 작은 것



class Solution {
    static class Edge implements Comparable<Edge>{
        int start;
        int time;
        int num;
        public Edge(int num,int start,int time){
            this.num=num;
            this.start=start;
            this.time=time;

        }
        @Override
        public int compareTo(Edge o){
            if(this.time!=o.time){
                return this.time-o.time;
            }else if(this.start!=o.start){
                return this.start-o.start;
            }else{
                return this.num-o.num;
            }
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->a.start-b.start);
        PriorityQueue<Edge> wait=new PriorityQueue<>();


        for(int i=0;i<jobs.length;i++){
            pq.add(new Edge(i,jobs[i][0],jobs[i][1]));
        }

        int total=0;
        int curr=0;
        //둘다 비는게 아니면 계속
        while(!pq.isEmpty()||!wait.isEmpty()){
            while(!pq.isEmpty()&&curr>=pq.peek().start){
                wait.add(pq.poll());
            }
            if(wait.isEmpty()){
                curr=pq.peek().start;
            }else{
                Edge edge=wait.poll();
                curr+=edge.time;
                total+=(curr-edge.start);
            }
        }

        return total/jobs.length;
    }
}