import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] commands = new int[N];
        
        // 명령을 배열에 역순으로 저장
        for (int i = N - 1; i >= 0; i--) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        
        // 명령에 따라 deque에 값을 추가
        for (int i = 1; i <= N; i++) {
            int command = commands[i - 1];
            if (command == 1) {
                dq.addFirst(i);
            } else if (command == 2) {
            	Integer first = dq.pollFirst(); 
                dq.addFirst(i);
                if (first != null) {
                    dq.addFirst(first);
                }
            } else {
                dq.addLast(i);
            }
        }
        
        while (!dq.isEmpty()) {
            sb.append(dq.poll()).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
