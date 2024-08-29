import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for(int tc = 1; tc<=T; tc++) {
			String[] order = br.readLine().split(""); // 명령어
			int n = Integer.parseInt(br.readLine()); // 배열 내의 숫자 수
			
			// 배열 입력 처리 (대괄호와 쉼표 제거)
			String input = br.readLine();
			input = input.substring(1, input.length() - 1); // 양 끝 대괄호 제거

			Deque<Integer> deque = new LinkedList<>(); // 숫자 덱(Deque)
			if (!input.isEmpty()) { // 빈 배열이 아닌 경우만 처리
				String[] elements = input.split(","); // 쉼표 기준으로 숫자 추출
				for(String element : elements) {
					deque.add(Integer.parseInt(element.trim())); // 숫자를 덱에 추가
				}
			}

			boolean isReversed = false;
			boolean error = false;
			for(String cmd : order) {
				if(cmd.equals("R")) { // 뒤집기 명령
					isReversed = !isReversed; // 뒤집기 상태 변경
				} else if(cmd.equals("D")) { // 첫 번째 수 버리기
					if(deque.isEmpty()) {
						System.out.println("error");
						error = true;
						break;
					} else {
						if(isReversed) {
							deque.removeLast(); // 뒤집힌 상태면 마지막 수 제거
						} else {
							deque.removeFirst(); // 아니면 첫 번째 수 제거
						}
					}
				}
			}

			if(!error) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while(!deque.isEmpty()) {
					if(isReversed) {
						sb.append(deque.removeLast()); // 뒤집힌 상태면 마지막 수부터 추가
					} else {
						sb.append(deque.removeFirst()); // 아니면 첫 번째 수부터 추가
					}
					if(!deque.isEmpty()) {
						sb.append(","); // 수 사이에 쉼표 추가
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
		}
	}
}
