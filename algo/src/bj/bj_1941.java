package bj;

import java.util.*;
import java.io.*;

public class bj_1941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>(); //
        boolean flag = false;//태그 안밖인지 판단

        for (int i = 0; i <line.length() ; i++) {

            char c = line.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    //스택에 있던 단어 꺼내기 (가꾸로 나옴)
                    result.append(stack.pop());
                }
                flag = true;
                result.append(c); // 괄호 시작
            } else if (c == '>') {
                flag = false; // 괄호 끝
                result.append(c);
            } else if (flag) {
                //태그 안이라면
                result.append(c); // 정방향
            } else if (!flag && c == ' ') {
                //태그 밖인데 공백으로 단어 구분됨
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
            } else if (!flag) {
                stack.push(c);
            }

        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }


        System.out.println(result);
    }
}