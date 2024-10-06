import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, K;
	public static int[] map = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		if(N == K) {
			System.out.println(0);
		}else {
			bfs(N);
		}
		
	}
	
	public static void bfs(int n) {
		Deque<Integer> dq = new ArrayDeque<>(); 
		dq.offer(n);
		map[n] = 1;
		
		while (!dq.isEmpty()) {
			int num = dq.poll();

			for(int i = 0; i<3; i++) {
				int next;
				
				if(i == 0) { // 앞으로 한칸
					next = num + 1;
				}else if(i == 1) { // 뒤로 한칸
					next = num - 1;
				} else { // 순간이동(두배 앞)
					next = num * 2;
				}
				
				if(next == K) { // 동생위치에 도달했다면 출력
					System.out.println(map[num]);
					return;
				}
				
				// 범위를 벗어나지 않고 방문하지 않았다면,
				if(next >= 0 && next < map.length && map[next] == 0) {
					dq.offer(next);
					map[next] = map[num] + 1;
				}
			}
		}
	}
		
}