import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		HashSet<String> hSet = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine()); // 출입 기록 수
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String chk = st.nextToken();
			// 퇴근이면 셋 내에서 제거 
			if(chk.equals("leave")) {
				hSet.remove(name);
			} else {
				hSet.add(name);
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String key : hSet) {
			list.add(key);
		}
		
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(String key : list) {
			System.out.println(key);
		}
	}
		
}