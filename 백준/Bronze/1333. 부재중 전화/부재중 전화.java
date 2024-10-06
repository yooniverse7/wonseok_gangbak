import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노래 수
        int L = Integer.parseInt(st.nextToken()); // 노래 길이
        int D = Integer.parseInt(st.nextToken()); // 안내 멘트 간격

        int totalTime = N * (L + 5) - 5; // 전체 노래 재생 종료 시간
        int result = 0; // 안내 멘트가 울리는 시간

        // 안내 멘트 간격으로 반복
        while (result <= totalTime) {
            // 노래 구간이 아닌 구간에 안내 멘트가 울릴 수 있는지 확인
            int start = result / (L + 5) * (L + 5); // 현재 주기 시작 시간
            int end = start + L; // 노래 끝 시간

            // 안내 멘트 시간이 노래가 끝난 후 울리는 경우 바로 출력
            if (result >= end) {
                System.out.println(result);
                return;
            }
            result += D; // 다음 안내 멘트 시간
        }
        
        // 마지막 노래가 끝난 후에 안내 멘트가 울리지 않은 경우
        System.out.println(result);
    }
}
