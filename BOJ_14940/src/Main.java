import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][]map;
	static int[][] result;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}; // 오, 아래, 왼, 위
	static int[] dy = {1, 0, -1, 0}; // 오, 아래, 왼, 위
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로 크기
		m = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[n][m]; // 지도
		result = new int[n][m]; // 결과 입력
		visited = new boolean[n][m]; // 방문 기록
		
		for(int i = 0; i<n; i++) { // 지도 채우기
			StringTokenizer ss = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(ss.nextToken());
				if (map[i][j] == 1) {
					result[i][j] = -1; // 이동할 수 없는 칸은 -1로 초기화
				}
			}
		}
		cute : for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 2) {
					bfs(i, j);
					result[i][j] = 0;
					break cute;
					
				}
			}
		}
	
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.printf(result[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y }); // 큐 삽입
		visited[x][y] = true; // 방문 기록
		
		
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
				if(map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
				
				q.add(new int[] {nextX, nextY}); // 다음 값 큐에 삽입
				result[nextX][nextY] = result[nowX][nowY] + 1; // 이전 값 + 1 입력
				visited[nextX][nextY] = true; // 방문 기록
				
			}
			
			
		}
	}

}
