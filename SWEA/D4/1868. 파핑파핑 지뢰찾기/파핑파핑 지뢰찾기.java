import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	public static int[][] arr;
	public static boolean[][] visited;
	public static int N;
	public static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1}; // 위, 아래, 오, 왼, 오위, 오아래, 왼위, 왼아래
	public static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
	public static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			cnt = 0;
			
			for(int i = 0; i<N; i++) {
				String[] elements = br.readLine().split("");
				for (int j = 0; j < elements.length; j++) {
					if(elements[j].equals("*")) { // 별부분에 -1넣기
						arr[i][j] = -1;
					}
				}
			}
			
			for(int i = 0; i<N; i++) { // 별 주변 ++채우기
				for(int j = 0; j<N; j++) {
					if(arr[i][j] == -1) {
						visited[i][j] = true; // 별 방문처리하기 
						sum(i, j);
					}
				}
			}
			
			for(int i = 0; i<N; i++) { // 0일 때 처리하기
				for(int j = 0; j<N; j++) {
					if(arr[i][j]==0 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			for(int i = 0; i<N; i++) { // 0이 아닌 값 처리하기
				for(int j = 0; j<N; j++) {
					if(!visited[i][j]) {
						cnt++;
					}
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
			
		}

		System.out.println(sb.toString());
	}
	
	
	public static void bfs(int x, int y) {
		Deque<int[]> deque = new ArrayDeque<int[]>();
		deque.offer(new int[] {x, y}); // 덱에 담기
		visited[x][y] = true; // 방문 체크
		while (!deque.isEmpty()) {
			int[] n = deque.poll();
			int nx = n[0];
			int ny = n[1];
			
			for(int i = 0; i<8; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				
				
				if(nextX < 0 || nextX >=N || nextY < 0 || nextY>=N || visited[nextX][nextY] || arr[nextX][nextY]==-1) {
					continue;
				}
				
				if(arr[nextX][nextY]!=0 && arr[nextX][nextY]!=-1 && !visited[nextX][nextY]) { // 0이 아닌 애들은 방문처리만 해주기
					visited[nextX][nextY] = true;
				}
				
				if (arr[nextX][nextY]==0 && !visited[nextX][nextY]) {
					deque.offer(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}
		
		cnt++;
	}
	
	
	public static void sum(int x, int y) { 
		for(int i = 0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx>=N || ny<0 || ny>=N || arr[nx][ny] == -1) {
				continue;
			}
			arr[nx][ny]++;
		}
	}

}
