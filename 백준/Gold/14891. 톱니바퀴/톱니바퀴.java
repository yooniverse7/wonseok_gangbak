import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr; // 톱니 배열
	public static int left, right;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8]; 
		
		for(int i = 0; i<4; i++) { 
			String str = br.readLine();
			for(int j =0; j<8; j++) {
				arr[i][j] = (int)str.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gear = Integer.parseInt(st.nextToken()) - 1; // 톱니 숫자
			int d = Integer.parseInt(st.nextToken()); // 방향
			checkGear(gear, d); 
		}
		
		int sum=0;
		int score = 1;
		for(int i = 0; i<4; i++) {
			sum += arr[i][0] * score;
			score *= 2;
		}
		System.out.println(sum);
		
	}
	
	public static void checkGear(int x, int y) { // 돌아가는 톱니바퀴인지 확인하기
		Queue<int[]> queue = new LinkedList<>();
		boolean visited[] = new boolean[4];
		
		visited[x] = true; // 들어온 톱니바퀴 숫자 방문처리
		queue.offer(new int[] {x,y}); // 큐에 톱니바퀴 숫자와 방향 추가
		
		while (!queue.isEmpty()) {
			int[] b = queue.poll();
			int gearNum = b[0];
			int turnNum = b[1];
			
			
			if(gearNum + 1 < 4 && visited[gearNum + 1] == false && arr[gearNum][2] != arr[gearNum+1][6]) { // 오른쪽 톱니 유효성 검사
				if(turnNum == -1) { // 바퀴가 반시계방향으로 돈다면,
					queue.offer(new int[] {gearNum+1, 1});
					visited[gearNum+1] = true; // 방문처리,,
				}else { // 바퀴가 시계방향으로 돈다면,
					queue.offer(new int[] {gearNum+1, -1});
					visited[gearNum+1] = true;
				}
			} 
			if(gearNum - 1 >= 0 && visited[gearNum - 1] == false && arr[gearNum][6] != arr[gearNum-1][2]) { // 왼쪽 톱니 유효성 검사
				if(turnNum == -1) { // 바퀴가 반시계방향으로 돈다면,
					queue.offer(new int[] {gearNum-1, 1});
					visited[gearNum-1] = true;
					
				}else { // 바퀴가 시계방향으로 돈다면,
					queue.offer(new int[] {gearNum-1, -1});
					visited[gearNum-1] = true;
				}
			}
			
			
			turnGear(gearNum, turnNum);
		}
		
		
		
	}
	
	
	public static void turnGear(int x, int y) { // 톱니바퀴 돌리기 
		if(y == -1) { // 반시계방향
			int temp = arr[x][0];
			for(int i = 0; i<7; i++) {
				arr[x][i] = arr[x][i+1];
			}
			arr[x][7] = temp;
		}else { // 시계방향
			int temp = arr[x][7];
			for(int i = 7; i>0; i--) {
				arr[x][i] = arr[x][i-1];
			}
			arr[x][0] = temp;
		}
	}

}
