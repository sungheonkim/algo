import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long s=Long.parseLong(br.readLine());

        long mid=0;
        long left=1;
        long right=2_000_000_000L;
        long max=0;
        while(left<=right){
            mid=(left+right)/2;

            long num=mid*(mid+1)/2; // 1~mid까지 합
            if(num<=s){
                left=mid+1;
                max=Math.max(max,mid);
            }else{
                right=mid-1;
            }
        }
        System.out.println(max);

        // Please write your code here.
    }
}