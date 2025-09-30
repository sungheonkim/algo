package bj;
import java.util.*;
import java.io.*;

public class bj_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        Deque<Character> stack=new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();

        // 숫자면 바로 출력
        //연산자는 스택에 넣자  +,- -> *,/ -> ()
        // ) 만나면 (전까지 연산자 다 출력

        for (int i = 0; i < str.length(); i++) {
            char tmp= str.charAt(i);

            if(tmp=='('){
                stack.add(tmp);
            }else if(tmp==')'){
                while(stack.peekLast()!='('){
                    //( 만날 때 까지
                    sb.append(stack.removeLast());
                }
                // ( 괄호 없애주기
                stack.removeLast();
            }else if(tmp=='*'||tmp=='/'){

                while (!stack.isEmpty() && (stack.peekLast() == '*' || stack.peekLast() == '/')) {
                    sb.append(stack.removeLast());
                }
                stack.add(tmp);
            }else if(tmp=='+'|| tmp=='-') {
                while(!stack.isEmpty() && stack.peekLast()!='('){
                    sb.append(stack.removeLast());// 괄호 아니면 자기보다 우선순위 높다가 같음
                }
                stack.add(tmp);
            }else sb.append(tmp); // 문자는 바로 넣기
        }

        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }

        System.out.println(sb);
    }
}
