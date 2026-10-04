import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1,o2)->(o1[1]-o2[1]));

        int lastTarget=-1;
        for(int i=0;i<targets.length;i++){
            int s=targets[i][0];
            int e=targets[i][1];



            if(s>=lastTarget){
                answer++;
                lastTarget=e;
            }
            // System.out.println(s+" "+e+" "+lastTarget+" "+answer);
        }

        return answer;
    }
}