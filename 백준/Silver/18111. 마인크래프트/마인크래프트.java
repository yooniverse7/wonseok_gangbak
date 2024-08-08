import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N, M, B;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        B = Integer.parseInt(st.nextToken()); // 인벤토리
        arr = new int[N][M];
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] < min) min = arr[i][j];
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        
        int minTime = Integer.MAX_VALUE; // 최저 시간
        int finalHeight = 0; // 최종 높이
        
        for (int k = min; k <= max; k++) {
            int checkTime = 0; // 걸리는 시간
            int checkB = B; // 사용 가능한 인벤토리 개수
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int checkNum = arr[i][j];
                    if (checkNum < k) { // 땅이 낮다면
                        checkTime += (k - checkNum);
                        checkB -= (k - checkNum);
                    } else if (checkNum > k) { // 땅이 높다면
                        checkTime += (checkNum - k) * 2;
                        checkB += (checkNum - k);
                    }
                }
            }
            
            if (checkB >= 0 && checkTime <= minTime) {
                minTime = checkTime;
                finalHeight = k;
            }
        }
        
        sb.append(minTime).append(" ").append(finalHeight);
        System.out.println(sb.toString());
    }
}
