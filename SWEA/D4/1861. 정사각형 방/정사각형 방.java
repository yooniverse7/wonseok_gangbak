import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Solution {
	
	public static int[] dx = {0, 1, 0, -1}; // 오 아래 왼 위
	public static int[] dy = {1, 0, -1, 0}; // 오 아래 왼 위
	public static int N;
	public static int[][] room; // 방 배열
	public static boolean[][] visited; // 방문 확인
	public static Map<Integer, Integer> result; // 결과 저장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];// 배열 초기화
			result = new HashMap<>(); // 결과 저장  초기화
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i<N; i++) { // 모두 담기
				for(int j = 0; j<N; j++) {
					bfs(i, j);
				}
			}
			
			int max = 0; // 가장 큰 value값
			int maxKey = Integer.MAX_VALUE;
			for(Integer key : result.keySet()) {
	            int value = result.get(key);
	            if(max < value) { // max 최대값 구하기
	            	max = value;
	            }
		    }
			
			for(Integer key : result.keySet()) {
				if(result.get(key) == max) {
					if(key<maxKey) {
						maxKey = key;
					}
				}
			}
			
			
		
			System.out.println("#" + tc + " " + maxKey + " " + max);
		}
	}
	
	public static void bfs(int x, int y) {
		Deque<int[]> dq = new ArrayDeque<>();
		visited = new boolean[N][N]; // 방문 배열 초기화
		visited[x][y] = true; // 방문체크
		dq.add(new int[] {x, y}); // 덱에 담기
		int cnt = 1; // 개수 세기
		while (!dq.isEmpty()) { // 큐가 빌 때 까지
			int now[] = dq.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				
				// 범위를 넘거나 방문한 값이라면 continue
				if(nextX >=N || nextX <0 || nextY >=N || nextY<0 || visited[nextX][nextY] == true) { 
					continue;
				}
				
				// 이전 값보다 1 크면서 방문하지 않았다면, 
				if(room[nextX][nextY] == room[nowX][nowY] + 1 && visited[nextX][nextY] == false) {
					dq.offer(new int[] {nextX, nextY}); // 덱에 추가
					visited[nextX][nextY] = true; // 방문처리
					cnt++; // 카운트
					
				}
			}
		}
		
		result.put(room[x][y], cnt);
	}
	

}
