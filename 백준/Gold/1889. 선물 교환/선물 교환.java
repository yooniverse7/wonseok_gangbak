import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static boolean[] visited; // 방문
	public static int[] cnt; // 길이 배열
	public static int[][] arr;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine()); // 학생 수
        visited = new boolean[N+1];
        arr = new int[N+1][2];
        cnt = new int[N+1];
      
        for(int i = 1; i<=N; i++) { // 리스트 채우기
        	st = new StringTokenizer(br.readLine());
        	int num1 = Integer.parseInt(st.nextToken());
        	int num2 = Integer.parseInt(st.nextToken());
        	arr[i][0] = num1;
        	arr[i][1] = num2;
        	cnt[num1]++;
        	cnt[num2]++;
        }
        // 개수가 2보다 작은 인덱스값을 담아줌 
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i<=N; i++) {
        	if(cnt[i] < 2) {
        		 dq.offer(i);
        		 visited[i] = true;
        	}
        }
        
       
        while (!dq.isEmpty()) {
			int n = dq.poll();
			for(int i = 0; i<2; i++) {
				cnt[arr[n][i]]--;
				if(cnt[arr[n][i]] <2 && !visited[arr[n][i]]) {
					dq.offer(arr[n][i]);
					visited[arr[n][i]] = true;
				}
			}
			
		}
        
        int c = 0;
        for(int i = 1; i<N+1; i++) {
        	if(cnt[i] == 2) {
        		c++;
        		sb.append(i).append(" ");
        	}
        	
        }
        sb.insert(0, "\n");
        sb.insert(0, c);
        
        System.out.println(sb.toString());
       
       
    }
    
}