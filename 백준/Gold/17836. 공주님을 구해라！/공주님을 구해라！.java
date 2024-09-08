import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, T; // 성 크기, 제한 시간
	public static int[][] castle; // 성
	public static boolean[][][] visited; // 방문 배열
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		castle = new int[N][M];
		visited = new boolean[N][M][2]; // 0일 때는 그람 없을 때, 1일 때는 그람 있을 때

		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = bfs(0, 0); // 구출 결과 
		if(result == -1) {
			System.out.println("Fail");
		}else {
			System.out.println(result);
		}
	}
		
	public static int bfs(int x, int y) {
		Deque<Node> dq = new ArrayDeque<>();
		dq.offer(new Node(x, y, 0, false));
		visited[x][y][0] = true; // 첫 위치 방문 처리
		
		while (!dq.isEmpty()) { // 큐가 비었거나 시간이 다 지났을 때 종료
			Node n = dq.poll(); 
			int nx = n.x; 
			int ny = n.y;
			
			// 시간 초과되면 break
			if(n.time > T) break; 
			// 공주를 찾으면 시간 리턴
			if(n.x == N-1 && n.y == M-1) {
				return n.time;
			}
			
			for(int i = 0; i<4; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];

				if(nextX >=0 && nextX <N && nextY >=0 && nextY <M) {
					if(!n.gram) { // 그람 없을 때,
						// 그람 없으면서 방문하지 않았다면, 
						if(castle[nextX][nextY] == 0 && !visited[nextX][nextY][0]) {
							// 현재 좌표, 현재 시간 + 1, 현재 그람의 상태 덱에 담기 
							dq.offer(new Node(nextX, nextY, n.time + 1, n.gram));
							// 방문처리 
							visited[nextX][nextY][0] = true;
						}
						// 그람 발견
						else if (castle[nextX][nextY] == 2 && !visited[nextX][nextY][0]) {
							dq.offer(new Node(nextX, nextY, n.time + 1, true));
							visited[nextX][nextY][0] = true;
						}
					}
					// 그람 있을 때,
					else {
						// 그람 있을 때는 1이여도 지나갈 수 있음
						if(!visited[nextX][nextY][1]) {
							dq.offer(new Node(nextX, nextY, n.time + 1, n.gram));
							visited[nextX][nextY][1] = true;
						}
					}
				}
			}
		}
		return -1;
		
	}	
	public static class Node {
		int x;
		int y;
		int time; // 걸린 시간 
		boolean gram; // 그람 유무
		
		public Node(int x, int y, int time, boolean gram) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.gram = gram;
		}
		
	}
		
}