import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 높이
			int W = Integer.parseInt(st.nextToken()); // 너비
			
			String[][] map = new String[H][W];
			
			int x = 0; // 전차 위치 
			int y = 0;
			
			for(int i = 0; i<H; i++) {
				String str = br.readLine();
				String[] elements = str.split("");
				
				for(int j = 0; j<W; j++) {
					map[i][j] = elements[j];
					
					// 전차 찾기
					if(map[i][j].equals(">") || map[i][j].equals("<")
					|| map[i][j].equals("^") || map[i][j].equals("v")) {
						x = i;
						y = j;
					}
				}
					
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String order = br.readLine(); // 명령 문자열
			String[] orders = order.split(""); 
			
			for(int i = 0; i<N; i++) {
				
				// U일 때 
				if (orders[i].equals("U")) { 
					map[x][y] = "^";
					if(x-1>=0 && map[x-1][y].equals(".")) { // 범위를 벗어나지 않고 평지라면,
						map[x-1][y] = "^"; // 해당 위치 모양 바꾸기
						map[x][y] = "."; // 기존의 위치 평지로 바꿔주기
						x--; // x값 바꾸기
			
					}
				}
				// D일 때 
				else if (orders[i].equals("D")) { 
					map[x][y] = "v";
					if(x+1<H && map[x+1][y].equals(".")) { // 범위를 벗어나지 않고 평지라면,
						map[x+1][y] = "v"; // 해당 위치 모양 바꾸기
						map[x][y] = "."; // 기존의 위치 평지로 바꿔주기
						x++; // x값 바꾸기
			
					}
				}
				// L일 때 
				else if (orders[i].equals("L")) { 
					map[x][y] = "<";
					if(y-1>=0 && map[x][y-1].equals(".")) { // 범위를 벗어나지 않고 평지라면,
						map[x][y-1] = "<"; // 해당 위치 모양 바꾸기
						map[x][y] = "."; // 기존의 위치 평지로 바꿔주기
						y--; // x값 바꾸기
			
					}
				}
				// R일 때 
				else if (orders[i].equals("R")) { 
					map[x][y] = ">";
					if(y+1<W && map[x][y+1].equals(".")) { // 범위를 벗어나지 않고 평지라면,
						map[x][y+1] = ">"; // 해당 위치 모양 바꾸기
						map[x][y] = "."; // 기존의 위치 평지로 바꿔주기
						y++; // x값 바꾸기
			
					}
				}
				
				
				// S일 때
				else {
					if(map[x][y].equals("^")) { // 위쪽 방향을 볼 때,
						for(int j = x; j>=0; j--) {
							if(map[j][y].equals("*")) { // 벽돌벽을 만나면
								map[j][y] = "."; // 평지로 바꿈 
								break;
							}
							if(map[j][y].equals("#")) { // 강철벽을 만나면
								break;
							}
							
						}
					}
					else if(map[x][y].equals("v")) { // 아래쪽 방향을 볼 때,
						for(int j = x; j<H; j++) {
							if(map[j][y].equals("*")) { // 벽돌벽을 만나면
								map[j][y] = "."; // 평지로 바꿈 
								break;
							}
							if(map[j][y].equals("#")) { // 강철벽을 만나면
								break;
							}
						}
					}
					else if(map[x][y].equals("<")) { // 왼쪽 방향을 볼 때,
						for(int j = y; j>=0; j--) {
							if(map[x][j].equals("*")) { // 벽돌벽을 만나면
								map[x][j] = "."; // 평지로 바꿈 
								break;
							}
							if(map[x][j].equals("#")) { // 강철벽을 만나면
								break;
							}
						}
					}
					else if(map[x][y].equals(">")) { // 오른쪽 방향을 볼 때,
						for(int j = y; j<W; j++) {
							if(map[x][j].equals("*")) { // 벽돌벽을 만나면
								map[x][j] = "."; // 평지로 바꿈 
								break;
							}
							if(map[x][j].equals("#")) { // 강철벽을 만나면
								break;
							}
						}
					}
				}
				
			}
			
			
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			
		}
		System.out.println(sb.toString());
	}
	

}
