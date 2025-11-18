package bj;
import java.util.*;
import java.io.*;

public class a_두배 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for (int t = 1; t <=T ; t++) {
            int cnt=0;
            int sum=0;
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n+1];
            List<Integer> newArr=new ArrayList<>(); //max(A[i] + i, i) 변경 후 관리

            StringTokenizer st=new StringTokenizer(br.readLine());

            for (int i = 1; i <=n ; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }

            for (int i = 1; i <=n ; i++) {
                newArr.add(Math.max(arr[i]+i,i)-arr[i]); // 중거량
            }

            int diff=2*n-sum;

            if(diff>0){
                Collections.sort(newArr,Collections.reverseOrder()); //내림 차순해서 큰 값부터 꺼내ㅐ서 처리
                while(diff>0){
                    if(cnt<n) {
                        diff -= newArr.get(cnt);
                        cnt++; // cnt가 인덱스 겸 몇개 빼는지 한번에 체크
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
