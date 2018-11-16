import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BJ1761_LCA_distanceForNodes {
	static class Edge{
		int e=0;
		int f=0;
		public Edge(int e, int f){
			this.e=e;
			this.f=f;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Edge> a[] = new List[n+1];
		for(int i=1; i<=n; i++){
			a[i] = new ArrayList<Edge>();
		}
		Edge p[] = new Edge[n+1];
		int d[] = new int[n+1];
		int c[] = new int[n+1];
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=1; i<n; i++){
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			int t3 = sc.nextInt();
			a[t1].add(new Edge(t2,t3));
			a[t2].add(new Edge(t1,t3));
			if(i==1){
				dq.add(t1);
				d[t1]=0;
				c[t1]=1;
				p[t1]=new Edge(0,0);
			}
		}
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			for(Edge x : a[tmp]){
				if(c[x.e]==1) continue;
				d[x.e] = d[tmp]+1;
				p[x.e] = new Edge(tmp,x.f);
				c[x.e] = 1;
				dq.add(x.e);
			}
		}
		int m = sc.nextInt();
		for(int i=1; i<=m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(d[u]<d[v]){
				int tmp = u;
				u = v;
				v = tmp;
			}
			
			int sol = 0;
			while(d[u]!=d[v]){
				sol += p[u].f;
				u = p[u].e;
			}
			while(u!=v){
				sol+=p[u].f;
				sol+=p[v].f;
				u = p[u].e;
				v = p[v].e;
			}
			System.out.println(sol);
		}
	}
	
}
