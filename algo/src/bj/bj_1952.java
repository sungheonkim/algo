package bj;

import java.util.*;
import java.io.*;
public class bj_1952 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n= Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str=br.readLine();
            Deque<Character> stack=new ArrayDeque<>();
            boolean flag=true;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='(') stack.add('(');
                else{
                    //짝을 못 찾는 예외
                    if(stack.isEmpty()) {
                        sb.append("NO\n");
                        flag=false;
                        break;
                    }else if(stack.peekLast()=='('){
                        stack.removeLast();
                    }
                }
            }
            // 위에서 예외 상황 발생 x
            if(flag) {
                if (stack.isEmpty()) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
