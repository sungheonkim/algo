import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int start,end;
        public Edge(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Edge o){
            return this.start-o.start;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Edge> input=new PriorityQueue<>();
        PriorityQueue<Integer> output=new PriorityQueue<>();

        for(int i=0;i<book_time.length;i++){
            int start=change(book_time[i][0]);
            int end=change(book_time[i][1]);
            input.add(new Edge(start,end));
        }

        //그다음에 이제 하나씩 방에 넣는데 종료 시간으로 관리?

        while(!input.isEmpty()){
            //들어가고싶은놈
            Edge curr=input.poll();

            //나갈놈 잇으면 내보내기
            if(!output.isEmpty()&&curr.start>=output.peek()){
                output.poll();
            }

            output.add(curr.end+10);


            answer=Math.max(answer,output.size());
        }



        return answer;
    }
    private static int change(String str){
        int h=Integer.parseInt(str.substring(0,2));
        int m=Integer.parseInt(str.substring(3,5));
        return h*60+m;
    }
}
// 시간 증가 시키면서 누적합 하고, 배열 정렬해서 최대값 방 구하면 될듯