package bj;

import java.util.*;
import java.io.*;
public class a_모자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int n=Integer.parseInt(br.readLine());
            int k=3;

            PriorityQueue<Integer> hat= new PriorityQueue<>();
            PriorityQueue<Integer> person =new PriorityQueue<>();

            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                person.add(Integer.parseInt(st.nextToken()));
            }
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                hat.add(Integer.parseInt(st.nextToken()));
            }
            int cnt=0;
            while(!hat.isEmpty() &&!person.isEmpty()){
                int diff=Math.abs(person.peek()-hat.peek());
                if(diff<=k){
                    cnt++;
                    person.poll();
                    hat.poll();
                }else{
                    person.poll();
                }
            }
            sb.append('#').append(t).append(' ').append(cnt).append('\n');
        }

        System.out.println(sb);
    }

}
