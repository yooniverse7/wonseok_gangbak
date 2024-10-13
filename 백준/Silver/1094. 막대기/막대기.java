import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        // X를 이진수로 표현했을 때 '1'의 개수만큼 필요한 막대의 수가 된다.
        while (X > 0) {
            if ((X & 1) == 1) { // 마지막 비트가 1인 경우
                count++;
            }
            X >>= 1; // X를 오른쪽으로 한 비트씩 이동
        }

        System.out.println(count);
    }
}
