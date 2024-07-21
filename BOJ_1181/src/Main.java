import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader 객체 생성
        int n = Integer.parseInt(br.readLine()); // 단어의 개수
        
        ArrayList<String> words = new ArrayList<>(); // 문자열 리스트 
        
        for (int i = 0; i < n; i++) { // 리스트 채우기
            words.add(br.readLine()); 
        }

  
        Collections.sort(words, new Comparator<String>() { // 단어 리스트 정렬
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    // 길이가 짧은 것부터 정렬
                    return s1.length() - s2.length();
                } else {
                    // 길이가 같으면 사전 순으로 정렬
                    return s1.compareTo(s2);
                }
            }
        });

        String pWord = ""; // 이전 단어를 저장할 변수
        StringBuilder sb = new StringBuilder(); // 출력할 결과를 저장
        for (String word : words) {
            if (!word.equals(pWord)) {
                // 현재 단어가 이전 단어와 다를 경우
                sb.append(word).append("\n"); // 단어 추가
                pWord = word; // 이전 단어 갱신
            }
        }

        System.out.print(sb.toString());

    }
}
