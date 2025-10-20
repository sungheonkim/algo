package bj;
import java.io.*;
import java.util.*;

public class bj_15811 {
    private static List<Character> alp;
    private static int[] alphaNum = new int[26]; // 'A'~'Z'에 해당하는 숫자 저장
    private static String a, b, c;
    private static int n;
    private static boolean[] visited = new boolean[10];
    private static boolean flag = false;
    private static Set<Character> firstChars = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();
        c = st.nextToken();

        int maxLen=Math.max(a.length(),b.length());

        if (c.length() < maxLen || c.length() > maxLen + 1) {
            System.out.println("NO");
            return;
        }

        firstChars.add(a.charAt(0));
        firstChars.add(b.charAt(0));
        firstChars.add(c.charAt(0));

        Set<Character> set = new HashSet<>();
        for (char tmp : a.toCharArray()) set.add(tmp);
        for (char tmp : b.toCharArray()) set.add(tmp);
        for (char tmp : c.toCharArray()) set.add(tmp);

        alp = new ArrayList<>(set);
        n = alp.size();

        if (n > 10) {
            System.out.println("NO");
            return;
        }

        dfs(0);

        if (!flag) {
            System.out.println("NO");
        }
    }

    private static void dfs(int depth) {
        if (flag) {
            return;
        }

        if (depth == n) {
            long numA = toNum(a);
            long numB = toNum(b);
            long numC = toNum(c);

            if (numA + numB == numC) {
                System.out.println("YES");
                flag = true;
            }
            return;
        }

        char target = alp.get(depth);
        for (int i = 0; i <= 9; i++) {
            if (firstChars.contains(target) && i == 0) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;

                alphaNum[target - 'A'] = i;

                dfs(depth + 1);

                visited[i] = false;

            }
        }
    }

    private static long toNum(String s) {
        long value = 0;
        for (char ch : s.toCharArray()) {

            value = value * 10 + alphaNum[ch - 'A'];
        }
        return value;
    }
}