import java.util.*;
import java.io.*;
// 0: 기본시간, 1: 기본 요금 , 2: 단위 시간, 3: 단위 요금
// record:
class Solution {
    private static int[] answer;
    private static List<String> cars;
    private static Map<String,Integer> inTime= new HashMap<>();
    private static Map<String,Integer> totalTime=new HashMap<>();
    public int[] solution(int[] fees, String[] records) {

        save(records);
        cal(fees);
        return answer;
    }
    private static void cal(int[] fees){
        cars=new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        answer=new int[cars.size()];
        for(int i=0;i<cars.size();i++){
            String car= cars.get(i);

            int fee=fees[1];

            if(totalTime.get(car)>fees[0]){
                int diff=totalTime.get(car)-fees[0];
                fee+=Math.ceil((double)diff/fees[2])*fees[3];
            }
            answer[i]=fee;
        }



    }
    private static void save(String[] records){

        for(int i=0;i<records.length;i++){

            String[] part= records[i].split(" ");

            int h=Integer.parseInt(part[0].substring(0,2));
            int m=Integer.parseInt(part[0].substring(3,5));
            int time= h*60+m;

            String car=part[1];
            String type=part[2];

            //System.out.println(car+" "+time);

            if(type.equals("IN")){
                inTime.put(car,time);
            }else{

                int diff=time-inTime.remove(car);
                totalTime.put(car,totalTime.getOrDefault(car,0)+diff);
            }
        }

        int maxTime=23*60+59;

        for(String car: inTime.keySet()){
            int diff= maxTime-inTime.get(car);
            totalTime.put(car,totalTime.getOrDefault(car,0)+diff);
        }
    }
}