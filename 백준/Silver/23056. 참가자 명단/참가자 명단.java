import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학급 수
		int M = Integer.parseInt(st.nextToken()); // 최대 인원
		
		Map<Integer, List<String>> map = new HashMap<>();
		
		while (true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int ban = Integer.parseInt(str.nextToken()); // 학급
			String name = str.nextToken(); // 이름
			
			if(ban == 0) { // 0들어오면 멈추기
				break;
			}
	
			
			if(map.containsKey(ban)) { // 해당 키값이 있으면 거기에 value 추가
				// 해당 키값이 있으면 거기에 value 추가
                List<String> list = map.get(ban);

                if (list.size() < M) { // M 이상이면 추가하지 않음
                    list.add(name);
                }
				
			} else { // 해당 키값없으면 새로운 맵 추가 
				List<String> list = new ArrayList<>();
				list.add(name);
				map.put(ban, list);
			}
		}
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet); // 키 값으로 정렬
		
		// 각 학급의 이름 리스트를 길이 순으로 정렬
		for (int key : keySet) {
			List<String> names = map.get(key);
			// 이름을 길이 순으로 오름차순 정렬
			Collections.sort(names, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) {
						return s1.compareTo(s2); // 사전순 정렬 
					}else {
						return Integer.compare(s1.length(), s2.length());						
					}
				}
			});
		
		}
		
		for(Integer key : keySet) { // 홀수 먼저 뽑기
			if(key % 2 != 0) {
				
				for(int i = 0; i<map.get(key).size(); i++) {
					System.out.println(key + " " + map.get(key).get(i));
				}
				
			}
		}
		
		
		for(Integer key : keySet) { // 짝수 먼저 뽑기
			if(key % 2 == 0) {
				for(int i = 0; i<map.get(key).size(); i++) {
					System.out.println(key + " " + map.get(key).get(i));
				}
				
			}
		}
		
	}

}
