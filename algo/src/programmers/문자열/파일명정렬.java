import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] parsed1 = detach(s1);
                String[] parsed2 = detach(s2);

                String head1 = parsed1[0];
                String head2 = parsed2[0];


                int num1 = Integer.parseInt(parsed1[1]);
                int num2 = Integer.parseInt(parsed2[1]);

                // 3. HEAD 비교 (대소문자 무시)
                int headResult = head1.compareToIgnoreCase(head2);
                if (headResult != 0) {
                    return headResult;
                }

                // 4. NUMBER 비교
                return Integer.compare(num1, num2);
            }
        });

        return files;
    }

    // 파일명을 HEAD와 NUMBER로 쪼개주는 함수
    private static String[] detach(String file) {
        int idx = 0;
        while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
            idx++;
        }
        String head = file.substring(0, idx);

        int numStart = idx;
        while (idx < file.length() && Character.isDigit(file.charAt(idx)) && (idx - numStart < 5)) {
            idx++;
        }
        String number = file.substring(numStart, idx);

        return new String[]{head, number};
    }
}