import java.util.*;
//합이 큰 큐에서 작은 큐로 가기
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();

        // 오버플로우 고려
        long sum1=0,sum2=0;

        // 초기작업
        for(int i=0;i<queue1.length;i++){
            int curr=queue1[i];
            sum1+=curr;
            q1.add(curr);
        }

        for(int i=0;i<queue2.length;i++){
            int curr=queue2[i];
            sum2+=curr;
            q2.add(curr);
        }

        if((sum1+sum2)%2!=0) return -1; // 두개합 홀수면 절대아노딤

        //큐 두개 길이 합친만큼 작업해도 안되면 영원히 안됨
        int size=(queue1.length+queue2.length)*2;
        int cnt=0;
        while(sum1!=sum2&&cnt<size){

            if(sum1>sum2){
                int curr= q1.poll();
                q2.add(curr);
                sum1-=curr;
                sum2+=curr;
            }else{
                int curr= q2.poll();
                q1.add(curr);
                sum2-=curr;
                sum1+=curr;
            }
            cnt++;
        }


        return sum1==sum2 ? cnt: -1;
    }
}