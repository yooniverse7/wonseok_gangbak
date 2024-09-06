import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int sharkSize;
	public static int[][] ocean;
	public static boolean[][] visited;
	public static int sX, sY;
	public static int sec;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	N = Integer.parseInt(br.readLine());
    	sharkSize = 2;
    	int eatCnt = 0; // 먹은 횟수
    	ocean = new int[N][N];
    	visited = new boolean[N][N];
    	sec = 0; // 걸린 시간 
    	
    	sX = 0; // 상어 위치 
    	sY = 0;
    	
    	for(int i = 0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<N; j++) {
    			ocean[i][j] = Integer.parseInt(st.nextToken());
    			if(ocean[i][j] == 9) { // 상어 위치 찾기
    				sX = i;
    				sY = j;
    			}
    		}
    	}
    	
    	
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? o1[2] - o2[2] : o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
    	pq.offer(new int[] {sX, sY, 0});
    	visited[sX][sY] = true;
    	ocean[sX][sY] = 0;
    	while (!pq.isEmpty()) {
    		int[] n = pq.poll();
    		int nx = n[0];
    		int ny = n[1];
    		int ns = n[2];
    		
    		if(ocean[nx][ny] < sharkSize && ocean[nx][ny] != 0) {
    			eatCnt ++;
    			ocean[nx][ny] = 0;
    			pq.clear();
    			visited = new boolean[N][N];
    			
    			if(eatCnt == sharkSize) {
    				sharkSize++;
    				eatCnt = 0;
    			}
    			sec = ns;
    		}
    		
    		for(int i = 0; i<4; i++) {
    			int nextX = nx + dx[i];
    			int nextY = ny + dy[i];
    			// 범위 벗어나거나 사이즈가 더 크다면 못지나감
    			if (nextX < 0 || nextX >=N || nextY < 0 || nextY>=N || ocean[nextX][nextY] > sharkSize || visited[nextX][nextY]) {
					continue;
				}

    			pq.offer(new int[] {nextX, nextY , ns+1});
    			visited[nextX][nextY] = true;

    		}
		}
    	
    	System.out.println(sec);
	}

    
    
    
}

