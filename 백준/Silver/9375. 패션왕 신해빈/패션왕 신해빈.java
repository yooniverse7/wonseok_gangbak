import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, List<String>> hMap = new HashMap<>();
			int result = N; // 결과값
			
			if(N == 0) { // 0일 때는 0 출력
				sb.append("0" + "\n");
				continue;
			}
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				String key = st.nextToken();
				if(hMap.containsKey(key)) { // 해당 키값이 있으면 거기에 value 추가
					hMap.get(key).add(value);
				} 
				else { // 해당 키값이 없으면 새로운 맵 추가 
					List<String> list = new ArrayList<>();
					list.add(value);
					hMap.put(key, list);
				}
				
			}
			
			int[] arr = new int[hMap.keySet().size()];
			int sum = 1;
			int idx = 0; 
			for(String key:hMap.keySet()) {
				if (hMap.get(key)!=null) {
					arr[idx] = hMap.get(key).size();
					idx++;
				}
			}
			
			for(int i = 0; i<hMap.size(); i++) {
				sum *= (arr[i] +1);
			}
			sum--;
			sb.append(sum + "\n");
			
		}
		System.out.println(sb.toString());
	}
}
