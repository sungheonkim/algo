package bj;
import java.util.*;
import java.io.*;

public class bj_1327 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //뒤집는거 반복?

    }
}
