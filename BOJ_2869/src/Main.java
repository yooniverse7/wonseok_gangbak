import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // 낮에 오를 수 있는 높이
		int B = Integer.parseInt(st.nextToken()); // 미끄러지는 길이 
		int V = Integer.parseInt(st.nextToken()); // 나무 막대 높이
		
		int day = (V-B)/(A-B); // 하루 전까지 오른 일 수
		if((V-B)%(A-B) != 0) { // 딱 떨어지지 않으면 하루 증가
			day++;
		}
		
		System.out.println(day);
	}

}
