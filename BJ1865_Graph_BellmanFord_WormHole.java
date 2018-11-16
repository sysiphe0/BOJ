import java.util.ArrayList;
import java.util.Scanner;

public class BJ1865_Graph_BellmanFord_WormHole {

	static class Edge{
		int s,e,c;
		public Edge(int s, int e, int c){
			this.s=s;
			this.e=e;
			this.c=c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			boolean isMinus = false;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int w = sc.nextInt();
			ArrayList<Edge> a1 = new ArrayList<Edge>();
			ArrayList<Edge> a2 = new ArrayList<Edge>();
			int[] d = new int[n+1];
			d[1] = 0;
			for(int i=2; i<=n; i++){
				d[i]=Integer.MAX_VALUE;
			}
			for(int i=0; i<m; i++){
				int t1 = sc.nextInt();
				int t2 = sc.nextInt();
				int t3 = sc.nextInt();
				a1.add(new Edge(t1,t2,t3));
				a1.add(new Edge(t2,t1,t3));
			}
			for(int i=0; i<w; i++){
				a2.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}
			
			for(int i=1; i<=n; i++){
				for(Edge edge : a1){
					if(d[edge.s] != Integer.MAX_VALUE && d[edge.e] > d[edge.s]+edge.c){
						d[edge.e] = d[edge.s]+edge.c;
					}
				}
				for(Edge edge : a2){
					if(d[edge.s] != Integer.MAX_VALUE && d[edge.e] > d[edge.s]-edge.c){
						d[edge.e] = d[edge.s]-edge.c;
						if(i==n || d[1]<0){
							isMinus = true;
							break;
						}
					}
				}
				if(d[1]<0) break;
			}
			
			if(isMinus){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
