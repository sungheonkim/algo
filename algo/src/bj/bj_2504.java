package bj;
import java.util.*;
import java.io.*;

public class bj_2504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();

        Stack<Character> stack =new Stack<>();
        int result=0;
        int temp=1; // 괄호 곱셈 계수
        // () ->2
        // []-> 3
        //여는 괄호와 닫는 괄호가 바로 만나면 현재 가지고 있는거 더하기

        // (x) -> 2 * x
        // [x] -> 3 * x
        // (xy)= (x)+(y)

        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);

            if(c=='('){
                stack.push(c);
                temp*=2;
            }
            else if(c=='['){
                stack.push(c);
                temp*=3;
            }
            else if(c==')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    result=0; //올바르지 않은 괄호열
                    break;
                }
                if(str.charAt(i-1)=='('){
                    result+=temp;
                }
                stack.pop();
                temp/=2; // )만나면 2로 나눔
            }
            else if(c==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    result=0;
                    break;
                }
                if(str.charAt(i-1)=='['){
                    result+=temp;
                }
                stack.pop();
                temp/=3;
            }

        }

        //스택이 비어있지 않으면 올바르지 않은 괄호열
        if(!stack.isEmpty()){
            result=0;
        }
        System.out.println(result);

    }
}
