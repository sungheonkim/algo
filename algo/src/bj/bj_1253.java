package bj;
import java.io.*;
import java.util.*;

public class bj_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n= Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        // 입력

        Arrays.sort(arr);

        // 어떤 수 = 두 개 수의 합 -> 앗싸 좋다
        //근데 left나 right가 i랑 같다면 두수의 합으로 절대 구성이 안된다

        int result=0;

        for (int i = 0; i < n; i++) {
            int left=0;
            int right=arr.length-1;

            while(left<right){
                if (left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }


                int sum=arr[left]+arr[right];

                //투포인터로 두 수의 합 찾아주기
                if(sum==arr[i]) {
                    //System.out.println(right+" left"+left);

                    result++;
                    break;
                }
                else if(sum<arr[i]) left++;
                else right--;

            }
        }
        System.out.println(result);

    }
}
