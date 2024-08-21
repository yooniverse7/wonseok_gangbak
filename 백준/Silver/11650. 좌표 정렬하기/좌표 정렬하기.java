import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class Point{
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
}
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> points = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points.add(new Point(x,y));
		}
		
		Collections.sort(points, new Comparator<Point>() { // 정렬
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x != o2.x) {
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o1.y, o2.y);
			}
			
		});
		
		
		for(Point point : points) {
			System.out.println(point.x + " " + point.y);
		}
	
	}

}
