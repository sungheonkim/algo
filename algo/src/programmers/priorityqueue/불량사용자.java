import java.util.*;
class Solution {
    // 전체 결과를 관리 해야됨
    private static Set<Set<String>> result=new HashSet<>();
    private static boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        visited=new boolean[user_id.length];
        dfs(user_id,banned_id,0,new HashSet<>());
        return result.size();
    }
    private static void dfs(String[] user_id, String[] banned_id,int index,Set<String> curr){

        //모든 밴목록 ㅇ
        if(index==banned_id.length){
            result.add(new HashSet<>(curr));
            return;
        }

        for(int i=0;i<user_id.length;i++){
            if(visited[i]) continue;

            if(isMatch(user_id[i],banned_id[index])){
                curr.add(user_id[i]);
                visited[i]=true;
                dfs(user_id,banned_id,index+1,curr);
                curr.remove(user_id[i]);
                visited[i]=false;
            }
        }

    }
    private static boolean isMatch(String user,String banned){
        if(user.length()!=banned.length()) return false;

        for(int i=0;i<user.length();i++){
            if(banned.charAt(i)=='*') continue;

            if(banned.charAt(i)!=user.charAt(i)) return false;
        }
        return true;
    }
}