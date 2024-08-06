import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<Integer> numbers = new HashSet<>(); 
		for(int i = 0; i<N; i++) { //해쉬 셋에 숫자 담기 
			int num = Integer.parseInt(st.nextToken());
			numbers.add(num);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st2.nextToken());
			if(numbers.contains(num)) { // contains를 사용하여 N안에 M의 수가 있는지 확인
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
