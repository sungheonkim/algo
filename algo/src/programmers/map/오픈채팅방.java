import java.util.*;
class Solution {
    private static Map<String,String> map=new HashMap<>();
    public String[] solution(String[] record) {
        String[] answer = {};

        for(int i=0;i<record.length;i++){
            String[] parse= record[i].split(" ");
            //System.out.println(parse[1]+" "+parse[2]);
            if(parse[0].equals("Enter")){
                map.put(parse[1],parse[2]);
            }else if(parse[0].equals("Change")){
                map.put(parse[1],parse[2]);
            }
        }
        List<String> list=new ArrayList<>();

        for(int i=0;i<record.length;i++){
            String[] parse= record[i].split(" ");
            if(parse[0].equals("Enter")){
                String str=map.get(parse[1])+"님이 들어왔습니다.";
                list.add(str);
            }else if(parse[0].equals("Leave")){
                String str=map.get(parse[1])+"님이 나갔습니다.";
                list.add(str);
            }

        }
        return list.toArray(new String[0]);
    }
}