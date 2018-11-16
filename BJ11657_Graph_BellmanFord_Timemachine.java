import java.util.ArrayList;
import java.util.Scanner;

public class BJ11657_Graph_BellmanFord_Timemachine {

	static class Edge{
		int s,e,c;
		
		public Edge(int s, int e, int c){
			this.s=s;
			this.e=e;
			this.c=c;
		}
	}
	
	static int n,m,d[];
	static ArrayList<Edge> a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;
		boolean isCycle = false;
		n = sc.nextInt();
		m = sc.nextInt();
		d = new int[n+1];
		a = new ArrayList<Edge>();
		d[1] = 0;
		for(int i=2; i<=n; i++){
			d[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<m; i++){
			a.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
		for(int i=1; i<=n; i++){
			for(Edge edge : a){
				if(d[edge.s] != Integer.MAX_VALUE && d[edge.s]+edge.c < d[edge.e]){ //d[] 와  Integer.Max 값을 꼭 비교해야함. (안하면 출력초과 오류 발생)
					if(i==n){
						isCycle = true;
						break;
					}else{
						d[edge.e] = d[edge.s]+edge.c;
					}
				}
			}
		}
		
		if(isCycle){
			System.out.println("-1");
		}else{
			for(int i=2; i<=n; i++){
				if(d[i]==Integer.MAX_VALUE){
					System.out.println("-1");
				}else{
					System.out.println(d[i]);
				}
			}
		}
		
	}
	
}
