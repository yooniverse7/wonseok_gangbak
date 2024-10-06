import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);
        System.out.println(sb.toString());
    }
    
    public static void quadTree(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            sb.append(video[x][y]);  // 모두 같은 색이면 해당 숫자를 추가
            return;
        }

        int newSize = size / 2;
        sb.append("(");  // 분할을 시작할 때 '(' 추가

        quadTree(x, y, newSize);                     // 왼쪽 위
        quadTree(x, y + newSize, newSize);           // 오른쪽 위
        quadTree(x + newSize, y, newSize);           // 왼쪽 아래
        quadTree(x + newSize, y + newSize, newSize); // 오른쪽 아래

        sb.append(")");  // 분할이 끝나면 ')' 추가
    }
    
    public static boolean isSameColor(int x, int y, int size) {
        int color = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != color) {
                    return false;  // 영역 내에 다른 색상이 있으면 false 반환
                }
            }
        }
        return true;  // 모두 같은 색상이면 true 반환
    }
}
