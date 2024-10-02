import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr;
	public static int N;
	public static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		
		nQueen(0);
		System.out.println(cnt);
		
	}
	
	public static void nQueen(int depth) {
		
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i< N; i++) {
			arr[depth] = i;
			if(check(depth)) {
				nQueen(depth+1);
			}
		}
	}
	
	public static boolean check(int depth) {
		for (int i = 0; i < depth; i++) {
			if(arr[depth] == arr[i]) {
				return false;
			}
			else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
			
		}
		return true;
	}
	

}
