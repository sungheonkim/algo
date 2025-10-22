package bj;
import java.io.*;
import java.util.*;


//1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액 그대로 배정
//2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액 계산 ->이상인 예산요청에 모두 상한액 배정 , 상한액 이하의 요청에는 요청 금액 그대로
//3.
public class bj_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        int max=0;
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(arr[i],max);
        }
        int m=Integer.parseInt(br.readLine());

        int left=0;
        int right=max;
        int answer=0;

        while(left<=right){
            int mid=(left+right)/2;
            long sum=0;

            for (int i = 0; i <n ; i++) {
                sum+=Math.min(arr[i],mid);
            }
            if(sum<=m){
                answer=mid;
                left=mid+1; // 더 큰 상한액
            }else{
                right=mid-1; //상한액 줄이기
            }
        }
        System.out.println(answer);

    }
}
