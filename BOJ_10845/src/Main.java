import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ��� ��
		Queue<Integer> q = new LinkedList<>(); // ť
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) { // ť�� ����
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			if(s.equals("pop")) { // ��������� -1 ���, ������ ����� ��� 
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(q.remove());
				}
			}
			
			if(s.equals("size")) { // ť ������ ���
				System.out.println(q.size());
			}
			
			if(s.equals("empty")) { // ť�� ��������� 1, �ƴϸ� 0 ���
				if (q.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				
			}
			
			if(s.equals("front")) { // ť�� ������� -1, �ƴϸ� ù��° ��� ���
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(q.peek());
				}
			}
			
			if(s.equals("back")) { // ������ �� ����ϱ�
				if(q.isEmpty()) {
					System.out.println("-1");
				}else {
					int lastNumber=((LinkedList<Integer>) q).peekLast();
                    System.out.println(lastNumber); 
				}
			}
		}
		
	}
}
