import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, M, cnt;
	public static int[][] arr;
	public static ArrayList<ArrayList<Integer>> list;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[N+1];
			cnt = 0;
			
			for(int i = 0; i<=N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i = 1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			for(int i = 1; i<N+1; i++) {
				if(!visited[i]) {
					visited[i] = true;
					bfs(i);
				}
			}
			
			sb.append("#").append(tc + " ").append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(x);
		while (!dq.isEmpty()) {
			int checkNum = dq.poll();
			List<Integer> value = list.get(checkNum);
			for(int i =0; i<value.size(); i++) {
				int num = value.get(i);
				if(!visited[num]) {
					dq.offer(num);
					visited[num] = true;
				}
			}
		}
		cnt++;
	}
	
}
