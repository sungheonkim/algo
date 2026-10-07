class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long s=1;
        long e=(long)times[times.length-1]*n;

        while(s<=e){
            long mid=(s+e)/2;
            long cnt=0;

            for(int i=0;i<times.length;i++){
                cnt+=mid/times[i]; // mid분 동안 각사람이 몇명 처리 가능한지
            }

            if(cnt>=n){
                answer=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return answer;
    }
}