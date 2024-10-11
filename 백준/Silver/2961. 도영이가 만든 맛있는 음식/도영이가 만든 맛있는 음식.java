import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	static int[][] arr;
	static int N; // 재료 개수, 신맛, 쓴맛
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int num1 = 1; // 신맛의 곱
	static int num2 = 0; // 쓴맛의 합
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(0);
		System.out.println(min);
	}
	
	public static void powerSet(int idx) {
		if(idx == N) {
			boolean chk = false; // 공집합도 계산하는 경우를 방지하기 위해 넣기
			for(int i = 0; i<N; i++) {
				if(visited[i]) {
					num1 *= arr[i][0];
					num2 += arr[i][1];
					chk = true;
				}
			}
			if(!chk) { // 공집합이면 그냥 리턴
				num1 = 1;
				num2 = 0;
				return;
			}
			int sum = Math.abs(num1 - num2);
			min = Math.min(min, sum);
			num1 = 1;
			num2 = 0;
			return;
		}
	
		// 부분집합 코드 - 어디서나 똑같음
		visited[idx] = true;
		powerSet(idx+1);
		visited[idx] = false;
		powerSet(idx+1);
	}
	
}
