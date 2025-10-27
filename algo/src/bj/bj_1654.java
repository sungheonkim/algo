package bj;

import java.util.*;
import java.io.*;
public class bj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int k=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());

        int max=0;

        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,arr[i]);
        }

        //모두 n개의 길이의 랜선으로 만들고 싶다

        long left=1;
        long right=max;


        while(left<=right){
            long mid = (left+right)/2;

            long cnt=0;

            for (int i = 0; i < k; i++) {
                cnt+=arr[i]/k;
            }
        }


    }
}
