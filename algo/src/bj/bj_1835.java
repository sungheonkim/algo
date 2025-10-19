package bj;
import java.io.*;
import java.util.*;

public class bj_1835 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //1 첫번쨰 카드 맨뒤로 가고 , 맨앞 카드가 1
        //2. 첫번쨰 카드 맨뒤로 , 2번 반복 후 맨 앞 카드 책상 2
        //3. 첫번째 카드 맨뒤로 세번 반복 하고 맨앞카드 3
        // 4. 첫번째 카드 맨뒤로 하고 그 다음 맨앞 카드 4

        Deque<Integer> dq=new ArrayDeque<>();
        dq.add(n);

        for(int i=n-1;i>0;i--){
            dq.addFirst(i);
            for (int j = 0; j <i ; j++) {
                dq.addFirst(dq.pollLast());
            }
        }
        StringBuilder sb=new StringBuilder();

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(' '); // 앞에서부터 꺼내서 추가
        }

        System.out.println(sb);

    }
}
