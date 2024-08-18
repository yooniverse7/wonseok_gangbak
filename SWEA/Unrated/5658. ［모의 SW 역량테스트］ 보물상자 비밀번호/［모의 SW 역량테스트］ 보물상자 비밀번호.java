import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 암호 개수
            int K = Integer.parseInt(st.nextToken()); // 순서
            
            String str = br.readLine();
            Set<Integer> key = new HashSet<>(); // 10진수값 들어갈 set
            
            // N/4번 회전 (각각의 회전 상태에서 부분 문자열 추출)
            for(int i = 0; i < N/4; i++) {  
                // 각 회전 상태에서 4개의 부분 문자열 추출
                for(int j = 0; j < N; j += N/4) {
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < N/4; k++) {
                        sb.append(str.charAt((j + k) % N));
                    }
                    int num = Integer.parseInt(sb.toString(), 16);
                    key.add(num);
                }
                
                // 문자열 회전: 마지막 문자를 맨 앞으로 이동
                str = str.charAt(N-1) + str.substring(0, N-1);
            }
            
            ArrayList<Integer> list = new ArrayList<>(key); // 정렬을 위해 list에 담기
            Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬 
            
            System.out.println("#" + tc + " " + list.get(K-1)); // K번째 큰 값 출력
        }
    }
}
