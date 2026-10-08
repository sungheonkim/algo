import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int[] prev=new int[n];
        int[] next=new int[n];

        for(int i=0;i<n;i++){
            prev[i]=i-1;
            next[i]=i+1;
        }
        next[n-1]=-1;

        Stack<Integer> stack=new Stack<>();

        for(String c: cmd){
            char op=c.charAt(0);
            if(op=='U'){
                int x=Integer.parseInt(c.substring(2));
                while(x-->0){
                    k=prev[k];
                }
            }else if(op=='D'){
                int x=Integer.parseInt(c.substring(2));
                while(x-->0){
                    k=next[k];
                }
            }else if(op=='C'){
                stack.push(k);
                if(prev[k]!=-1) next[prev[k]]=next[k];
                if(next[k]!=-1) prev[next[k]]=prev[k];

                k=(next[k]!=-1) ? next[k] : prev[k];
            }else if(op=='Z'){
                int r=stack.pop();
                if(prev[r]!=-1) next[prev[r]]=r;
                if(next[r]!=-1) prev[next[r]]=r;
            }
        }
        StringBuilder sb=new StringBuilder("O".repeat(n));
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'X');
        }

        return sb.toString();
    }
}