package bj;
import java.util.*;
import java.io.*;

public class bj_30105 {
    private static Set<Integer> set= new HashSet<>();
    private static Set<Integer> dis =new HashSet<>();
    private static List<Integer> result=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            set.add(arr[i]); // 원본 셋
        }


        //원소별 모든 거리 구하기
        for (int i = 1; i <n; i++) {
            dis.add(arr[i]-arr[0]);

        }

        //이빨 자국 제대로 찍히는지 확인하기
        for(int k : dis){
            if(valid(k)){
                //만족하는 이빨 자국이 된다면 결과에 추가
                result.add(k);
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(' ');
        }

        System.out.print(sb);


    }
    private static boolean valid(int k){
        Set<Integer> used=new HashSet<>();

        for(int target : set){
            if(used.contains(target)){
                continue; // 이미 처리함
            }
            if(set.contains(target+k)){
                // k 간격만큼 더 큰 수가 존재
                used.add(target);
                used.add(target+k);
            }else if(set.contains(target-k)){
                //k 간격만큼 더 작은 수가 존재
                used.add(target);
                used.add(target-k);
            }else{
                //간격만큼 차이나는게 존재 안하면 false
                return false;
            }
        }
        return used.size()==set.size(); // 모든 수가 채택되어야 한다.
    }
}
