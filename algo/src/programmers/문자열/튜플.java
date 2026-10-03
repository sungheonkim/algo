import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer;
        s=s.substring(2,s.length()-2);

        String[] group = s.split("\\}\\,\\{");

        Arrays.sort(group,(a,b)->Integer.compare(a.length(),b.length()));
        //System.out.println(s);

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<group.length;i++){
            String[] part= group[i].split(",");
            for(int j=0;j<part.length;j++){
                int num=Integer.parseInt(part[j]);
                if(!list.contains(num))
                    list.add(num);
            }
        }

        answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}