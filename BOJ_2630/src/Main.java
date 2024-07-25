import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.attribute.Size2DSyntax;

public class Main {
	
	static int[][] paper;
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i = 0; i<N; i++) { // 배열 채우기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		colorCheck(0, 0, N); // 자르는 메서드 호출
		System.out.println(white);
		System.out.print(blue);
		
	}
	
	public static void colorCheck(int x, int y, int N) {
		if(cutting(x, y, N)) {
			if(paper[x][y] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		int newN = N/2;
		colorCheck(x, y, newN);
		colorCheck(x, y+newN, newN);
		colorCheck(x+newN, y, newN);
		colorCheck(x+newN, y+newN, newN);
		
	}
	
	public static boolean cutting(int x, int y, int N) {
		int color = paper[x][y]; // 첫번째 원소로 시작
		
		for(int i = x; i<x+N; i++) {
			for(int j = y; j < y+N; j++) {
				if(paper[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}
