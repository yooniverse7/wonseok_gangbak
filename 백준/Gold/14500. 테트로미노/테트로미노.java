import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int[][] arr;
	public static int max;
	public static int sum, sum1;
	
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); // 가로
    	M = Integer.parseInt(st.nextToken()); // 세로
    	max = 0; // 최댓값 초기화
    	
    	arr = new int[N][M];
    	for(int i = 0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i<N; i++) { // 
    		for(int j = 0; j<M; j++) {
    			maxCheck(i, j);
    		}
    	}
    	
    	System.out.println(max);
    	
	}
    
    
    public static void maxCheck(int x, int y) {
    	
		if(x+3 < N) { // 일자 세로 박스
			sum = 0; // 세로 확인
			for(int i = 0; i<4; i++) {
				sum +=arr[x+i][y];
			}
			max = Math.max(sum, max);
		}
		if(y+3 < M) { // 일자 가로 박스
			sum = 0; // 세로 확인
			for(int i = 0; i<4; i++) {
				sum +=arr[x][y+i];

			}
			max = Math.max(sum, max);

		}
		
		if(x+1 < N && y+1 < M) { // 네모 박스 
			sum = arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x+1][y+1];
			max = Math.max(sum, max);
		}
    	
		if(x+2<N && y-1>=0) { // 기역자 모양 1, 3번
			sum = arr[x+2][y-1]; // 3번
			sum1 = arr[x][y-1]; // 1번 
			for(int i = 0; i<3; i++) {
				sum += arr[x+i][y];
				sum1 += arr[x+i][y];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
			
		}
		
		if(x+2<N && y+1<M) { // 기역자 모양 2, 4번
			sum = arr[x][y+1]; // 2번
			sum1 = arr[x+2][y+1]; // 4번
			for(int i = 0; i<3; i++) {
				sum += arr[x+i][y];
				sum1 += arr[x+i][y];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
			
		}
		
		if(x-1>=0 && y+2<M) { // 니은자 모양 1, 2번
			sum = arr[x-1][y]; // 1번
			sum1 = arr[x-1][y+2]; // 2번
			for(int i = 0; i<3; i++) {
				sum += arr[x][y+i];
				sum1 += arr[x][y+i];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
		}
		
		if(x+1<N && y+2<M) { // 니은자 모양 3, 4번
			sum = arr[x+1][y]; // 3번
			sum1 = arr[x+1][y+2]; // 4번
			for(int i = 0; i<3; i++) {
				sum += arr[x][y+i];
				sum1 += arr[x][y+i];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
		}
		
		if (y-1 >=0 && y+1<M && x+1<N) { // 리을자 모양 1, 2번
			sum = arr[x+1][y-1] + arr[x][y+1]; // 1번
			sum1 = arr[x][y-1] + arr[x+1][y+1]; // 2번
			for(int i = 0; i<2; i++) {
				sum += arr[x+i][y];
				sum1 += arr[x+i][y];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
		}
		
		if (y+1<M && x-1>=0 && x+1<N) { // 리을자 모양 3, 4번
			sum = arr[x-1][y] + arr[x+1][y+1]; // 3번
			sum1 = arr[x-1][y+1] + arr[x+1][y]; // 4번
			for(int i = 0; i<2; i++) {
				sum += arr[x][y+i];
				sum1 += arr[x][y+i];
			}
			max = Math.max(sum, max);
			max = Math.max(sum1, max);
		}
		
		if(x+1<N && y+2<M) { // ㅜ 
			sum = arr[x+1][y+1];
			for(int i = 0; i<3; i++) {
				sum += arr[x][y+i];
			}
			max = Math.max(sum, max);
		}
		if(x-1>=0 && y+2<M) { // ㅗ
			sum = arr[x-1][y+1];
			for(int i = 0; i<3; i++) {
				sum += arr[x][y+i];
			}
			max = Math.max(sum, max);
		}
		
		if(x+2<N && y-1>=0) { // ㅓ
			sum = arr[x+1][y-1];
			for(int i = 0; i<3; i++) {
				sum += arr[x+i][y];
			}
			max = Math.max(sum, max);
		}
		if(x+2<N && y+1<M) { // ㅏ
			sum = arr[x+1][y+1];
			for(int i = 0; i<3; i++) {
				sum += arr[x+i][y];
			}
			max = Math.max(sum, max);
		}
	}
    
}

