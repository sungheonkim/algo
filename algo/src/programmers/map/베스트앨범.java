import java.util.*;
//장르, 번호, 횟수 -> 맵
//장르, 총 횟수 -> 맵
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answer=new ArrayList<>();

        Map<String,Map<Integer,Integer>> map =new HashMap<>();
        Map<String,Integer> totalMap=new HashMap<>();

        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            int play=plays[i];

            //장르별 전체 횟수 관리
            totalMap.put(genre,totalMap.getOrDefault(genre,0)+play);

            if(!map.containsKey(genre)){
                map.put(genre,new HashMap<>());
            }

            map.get(genre).put(i,play);

        }

        //장르별 총 횟수로 정렬
        List<String> sortedList=new ArrayList<>(totalMap.keySet());
        sortedList.sort((a,b)->totalMap.get(b)-totalMap.get(a));

        // for(int i=0;i<sortedList.size();i++){
        //     System.out.println(sortedList.get(i));
        // }

        for(String genre: sortedList){
            Map<Integer,Integer> inner= map.get(genre);

            List<Integer> sortedInner=new ArrayList<>(inner.keySet());
            sortedInner.sort((a,b)->inner.get(b)-inner.get(a));

            answer.add(sortedInner.get(0));
            if(sortedInner.size()>1){
                answer.add(sortedInner.get(1));
            }

        }

        int[] arr=new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            arr[i]=answer.get(i);
        }

        return arr;
    }
}