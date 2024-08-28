import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static String[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) { // 일반인 구역
			String[] element = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				arr[i][j] = element[j];
			}
		}
		int result1 = 0; // 일반인 구역 수
		for(int i = 0; i<N; i++) { // 일반인 구역
			for(int j = 0; j<N; j++) {
				if(!visited[i][j]) {
					result1+= dfs(i, j);
				}
			}
		}
		visited = new boolean[N][N]; // 초기화 
		
		for(int i = 0; i<N; i++) { // 적록색약 구역
			for(int j = 0; j<N; j++) {
				if(arr[i][j].equals("G")) { // G구역을 R로 바꾸기 
					arr[i][j] = "R";
				}
			}
		}
		int result2 = 0; // 적록색약 구역 수
		for(int i = 0; i<N; i++) { // 일반인 구역
			for(int j = 0; j<N; j++) {
				if(!visited[i][j]) {
					result2+= dfs(i, j);
				}
			}
		}
		
		
		
		System.out.println(result1 + " " + result2);
	}
	
	private static int dfs(int x, int y) {
		int cnt = 1;
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {x, y});
		visited[x][y] = true;
		while (!stack.isEmpty()) {
			int[] n = stack.pop();
			int nx = n[0];
			int ny = n[1];
			for(int i = 0; i<4; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				if(nextX <0 || nextX>=N || nextY < 0 || nextY >= N || visited[nextX][nextY]) continue;
				if(!visited[nextX][nextY] && arr[nx][ny].equals(arr[nextX][nextY])) {
					stack.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
			
		}
		
		return cnt;
	}

}
