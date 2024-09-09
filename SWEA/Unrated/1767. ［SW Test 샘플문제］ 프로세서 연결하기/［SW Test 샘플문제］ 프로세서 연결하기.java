import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 0, 1, 0}; // 오, 위, 왼, 아래
	public static int[] dy = {0, -1, 0, 1};
	public static int lineCnt; // 코어 개수, 선 개수 
	public static ArrayList<int[]> coreList;
	public static int minLineCnt= Integer.MAX_VALUE; // 최소 선 길이 
	public static int maxCoreCnt; // 연결된 코어 수 

	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc =1; tc<=T; tc++) {
    		N = Integer.parseInt(br.readLine());
    		arr = new int[N][N];
    		visited = new boolean[N][N];
    		coreList = new ArrayList<>();
    		lineCnt = 0;
    		maxCoreCnt = 0;
    		
    		for(int i = 0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<N; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    				if(arr[i][j] == 1) {
    					if(i != 0 && j != 0 && i != N-1 && j != N-1) {
    						coreList.add(new int[] {i, j}); 
    					}
    					visited[i][j]= true;     					
    				}
    			}
    		}
    		
    		dfs(0, 0, 0); // 리스트에서 꺼낼 순서, 연결된 코어 수, 현재 라인 길이 
    		
    		sb.append("#" + tc).append(" ").append(minLineCnt).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    	
	}
    
    public static void dfs(int cnt, int connectedCore, int currentLine) {
		if(cnt == coreList.size()) { // 모든 가능한 코어 처리 후 최소 라인 길이 갱신
			// 지금까지 연결된 코어 수가 더 많으면 갱신
			if(connectedCore > maxCoreCnt) {
				maxCoreCnt = connectedCore;
				minLineCnt = currentLine;
				
			// 같은 수의 코어 연결 시 선 길이 비교해 최소 길이 갱신
			}else if(connectedCore == maxCoreCnt) {
				minLineCnt = Math.min(minLineCnt, currentLine);
			}
			return;
		}
		
		int[] n = coreList.get(cnt);
		int nx = n[0];
		int ny = n[1];
		
		for(int i = 0; i<4; i++) {
			int nextX = nx;
			int nextY = ny;
			int currentCnt = 0; // 현재 선 개수 
			
			boolean isOk = true; // 해당 라인이 가능한지 판단
			while (true) {
				nextX += dx[i];
				nextY += dy[i];
				
				// 범위 벗어나면 멈춤
				if(nextX <0 || nextX >=N || nextY<0 || nextY >=N) break;
				
				// 다른 코어나 선을 만나면 멈춤
				if(arr[nextX][nextY] == 1 || visited[nextX][nextY]) {
					isOk = false; // 못쓰는 라인으로 판단 
					break;
				}
 
			}
			// 좌표 초기화
			nextX = nx;
			nextY = ny;
			
			// 갈 수 있는 길이라면 방문처리 하기
			if(isOk) {
				// 현재 방향으로 선 연결 
				while (true) {
					nextX += dx[i];
					nextY += dy[i];
					
					// 범위 벗어나면 멈춤 
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >=N) {
						break;
					}
					
					visited[nextX][nextY] = true;
					currentCnt++;
				}
				dfs(cnt+1, connectedCore+1, currentLine + currentCnt);

				
				// 백트래킹 
				nextX = nx;
				nextY = ny;
				
				while (true) {
					nextX += dx[i];
					nextY += dy[i];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >=N) {
						break;
					}
					
					visited[nextX][nextY] = false;

				}
				
			}
			
			else {
				// 연결하지 않고 넘어가기 
				dfs(cnt+1, connectedCore, currentLine);
			}
		}
	}

}

