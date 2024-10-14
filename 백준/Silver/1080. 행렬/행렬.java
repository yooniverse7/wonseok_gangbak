import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;     // 행렬의 크기 N, M
    public static int[][] A;    // 원래 행렬 A
    public static int[][] B;    // 목표 행렬 B

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        // 행렬 A 입력 받기
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 행렬 B 입력 받기
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 뒤집는 것이 불가능한 경우 
        if (N < 3 || M < 3) {
            if (isSame()) System.out.println(0); // 이미 두 행렬이 같은 경우
            else System.out.println(-1);         // 다르면 변환 불가
            return;
        }

        int count = 0; // 3x3 뒤집기 횟수
        for (int i = 0; i <= N - 3; i++) {        // 행렬의 범위 내에서 3x3 뒤집기 가능 위치 확인
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {         // 현재 위치에서 A와 B가 다른 경우
                    flip(i, j);                   // 3x3 뒤집기 수행
                    count++;                      // 뒤집기 횟수 증가
                }
            }
        }

        // 모든 변환이 끝난 후 A와 B가 같은지 확인
        if (isSame()) System.out.println(count); // 같으면 뒤집기 횟수 출력
        else System.out.println(-1);             // 다르면 변환 불가
    }

    // 3x3 영역의 값을 뒤집는 메소드
    public static void flip(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] = 1 - A[i][j]; // 0은 1로, 1은 0으로 변환
            }
        }
    }

    // 두 행렬 A와 B가 같은지 비교하는 메소드
    public static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) { // 다르면 false 반환
                    return false;
                }
            }
        }
        return true; // 모든 원소가 같으면 true 반환
    }
}
