import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int num; // 단지번호 
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static StringBuilder sb;
	public static ArrayList<Integer> list; // 결과 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		num = 0;
		
		for(int i = 0; i<N; i++) {
			String[] elements = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(elements[j]);
			}
		}

		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					num++;
					dfs(i, j); 
					
				}
			}
		}
		
		for(int i = 1; i<=num; i++) {
			int sum =0;
			for(int j = 0; j<N; j++) {
				for(int z = 0; z<N; z++) {
					if(arr[j][z] == i) {
						sum++;
					}
				}
			}
			list.add(sum);
		}
		Collections.sort(list);
		sb.append(num + "\n");
		for(int i = 0; i<num; i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = num;
		for(int i = 0; i<4; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextX >=N || nextY < 0|| nextY >= N || visited[nextX][nextY]) continue;
			if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
				visited[nextX][nextY] = true;
				arr[nextX][nextY] = num;
				dfs(nextX, nextY);
			}
		}
	}

}
