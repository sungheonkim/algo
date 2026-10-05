import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        answer=bfs(begin,target,words);

        return answer;
    }
    private static int bfs(String begin,String target,String[] words){
        Queue<String> q=new LinkedList<>();
        boolean[] visited=new boolean[words.length];
        int step=0;
        q.add(begin);

        while(!q.isEmpty()){

            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();

                if(curr.equals(target)){
                    return step;
                }
                for(int j=0;j<words.length;j++){
                    String next=words[j];
                    if(visited[j]) continue;
                    if(isNext(curr,next)){
                        q.add(next);
                        visited[j]=true;
                    }
                }
            }
            step++;

        }

        return 0;

    }
    private static boolean isNext(String curr,String next){
        int cnt=0;

        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)!=next.charAt(i)) cnt++;
        }
        if(cnt>1) return false;
        return cnt==1;
    }
    // 큐 넣을때 한글자 이상 차이나는지 확인하기
}