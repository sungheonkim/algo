import java.util.*;
import java.io.*;
public class Main {
    private static int n,ans=0;
    private static List<Integer> seq=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        per(0);

        System.out.println(ans);

    }
    private static void per(int size){
        if(size==n){
            if(isBeatiful()){
                ans++;
            }
            return;
        }

        for(int i=1;i<=4;i++){
            seq.add(i);
            per(size+1);
            seq.remove(seq.size()-1);
        }

    }
    private static boolean isBeatiful(){
        int i=0;

        while(i<n){
            int num=seq.get(i);
            int next=i+num;

            if(i+num>n){
                return false;
            }

            for(int j=i;j<i+num;j++){
                if(num!=seq.get(j)){
                    //숫자만큼 연속된 구간에서 다르 숫자가 나오면 바로 false
                    return false;
                }
            }
            i+=num;
        }
        return true;
    }
}