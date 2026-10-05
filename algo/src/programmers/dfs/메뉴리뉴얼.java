import java.util.*;
class Solution {
    //메뉴 조합과 주문 횟수
    private static Map<String,Integer> map;
    private static List<String> answer=new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {

        for(int len : course){
            map=new HashMap<>();
            int maxCnt=0; // 해당 길이 일 때 가장 많이 주문된 횟수

            for(String order: orders){
                char[] arr=order.toCharArray();
                Arrays.sort(arr);

                if(arr.length>=len){
                    comb(arr,new StringBuilder(),0,len);
                }
            }

            // 최대값 찾기
            for(int count:map.values()){
                if(count>=2){
                    maxCnt=Math.max(maxCnt,count);
                }
            }

            //최대값과 동일한 횟수로 주문된 조합을 정답에 추가
            if(maxCnt>=2){
                for(String key:map.keySet()){
                    if(map.get(key)==maxCnt){
                        answer.add(key);
                    }
                }
            }


        }

        Collections.sort(answer);


        return answer.toArray(new String[0]);
    }
    //조합 구하기
    private void comb(char[] arr, StringBuilder sb,int start,int len){
        if(sb.length()==len){
            String str=sb.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int i=start;i<arr.length;i++){
            sb.append(arr[i]);
            comb(arr,sb,i+1,len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}