import java.util.*;
import java.io.*;
// 1.대기 트럭 큐에 다 올리기
// 2. 다리 올라가 있는 큐 -> 제한무게까지 다 올려야됨
// 3. 매 시간초마다 대기 큐 , 다리 올라가 있는 큐 사이즈 체크해서 둘다 0이면 끝인듯

class Solution {
    private static Queue<Integer> wait=new LinkedList<>();
    private static Queue<Integer> going=new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        for(int i=0;i< truck_weights.length;i++){
            wait.add(truck_weights[i]);
        }

        for(int i=0;i<bridge_length;i++){
            going.add(0);
        }
        int totalWeight=0;
        int time=0;

        while(true){
            time++;

            //맨앞꺼 지나감 처리
            totalWeight-=going.poll();

            if(!wait.isEmpty() &&weight>=totalWeight+wait.peek()){
                int next=wait.poll();
                going.add(next);
                //총 용량에서 더해주기
                totalWeight+=next;

            }else{
                //다리 길이 유지
                going.add(0);
            }


            if(wait.isEmpty() && totalWeight==0) break;
        }
        System.out.println(time);



        return time;
    }
}