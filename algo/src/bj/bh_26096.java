package bj;
import java.io.*;
import java.util.*;

public class bh_26096 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //키 값과 언제부터 춤을 췄는지 시점 저장
//        TreeMap<String,Integer> treeMap=new TreeMap<>();
//        treeMap.put("ChongChong",0);  //총총은 무조건 맨처음
        Set<String> set=new HashSet<>();
        set.add("ChongChong");


        int n=Integer.parseInt(br.readLine());

        for (int i = 1; i <=n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            String A=st.nextToken();
            String B=st.nextToken();
//
//            //a안춤 b춤
//            if(!treeMap.containsKey(A)&&treeMap.containsKey(B)){
//                treeMap.put(A,i);
//            }else if(treeMap.containsKey(A)&&!treeMap.containsKey(B)){
//                //a춤 b안춤
//                treeMap.put(B,i);
//            }
            if(set.contains(A)){
                set.add(B);
            }else if(set.contains(B)) set.add(A);


        }
        System.out.println(set.size());
//        System.out.println(treeMap.size());

    }
}
