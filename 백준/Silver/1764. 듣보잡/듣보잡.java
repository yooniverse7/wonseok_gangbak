import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수
		String str;
		
		
		HashMap<String, Integer> hMap = new HashMap<>();
		
		int num = 1;
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			hMap.put(str, num);
		}
		
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			if(hMap.containsKey(str)) {
				hMap.replace(str, num+1);
			}else {
				hMap.put(str, num);
			}
		}
		
		
		for (String key : hMap.keySet()) {
			if(hMap.get(key) != 1) {
				list.add(key);
			}
		}

		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
