import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1922_Graph_Prim_NetworkConnection {

	static int n,m,v[],ans;
	static List<Edge>[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			v = new int[n+1];
			p = (List<Edge>[]) new List[n+1];
			for(int i=1; i<=n; i++){
				p[i] = new ArrayList<Edge>();
			}
			for(int i=1; i<=m; i++){
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				int tmp3 = sc.nextInt();
				p[tmp1].add(new Edge(tmp2,tmp3));
				p[tmp2].add(new Edge(tmp1,tmp3));
			}
			
			Compare cmp = new Compare();
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
			pq.add(new Edge(1,0));
			while(!pq.isEmpty()){
				Edge parent = pq.poll();
				if(v[parent.e]==1) continue;
				ans += parent.c;
				v[parent.e] = 1;
				for(Edge child : p[parent.e]){
					if(v[child.e]==0){
						pq.add(new Edge(child.e,child.c));
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static class Edge{
		int e;
		int c;
		public Edge(int e, int c){
			this.e=e;
			this.c=c;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
	
}
