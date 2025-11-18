package bj;

import java.io.*;
import java.util.*;
public class bj_2343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];
        int max=0; // left  쓸거임
        int sum=0; // right 쓸거임

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(arr[i],max);
            sum+=arr[i];
        }

        int left=max; //최소값은 무조건 블루레이 크기 중 최대 보다 커야됨 (안그러면 아예 못담음)
        int right=sum;
        int answer=0;

        while(left<=right){
            int mid=(left+right)/2;
            int cnt=1;
            int total=0;

            for (int i = 0; i < n; i++) {
                if(total+arr[i]>mid){
                    cnt++;
                    total=arr[i]; // 새로운 블루레이에 담기
                }else{
                    total+=arr[i];
                }
            }
            if(cnt<=k) {
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.println(answer);

    }
}
