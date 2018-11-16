import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BJ1197_Graph_Kruskal_MST {

	static class Edge{
		int s;
		int e;
		int c;
		
//		public Edge(){
//			this(0,0,0);
//		}
		
		public Edge(int s, int e, int c){
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
	
	static int n,m,ans,p[];
	static ArrayList<Edge> a;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 1;
		for(int tc=1; tc<=T; tc++){
			n = sc.nextInt();
			m = sc.nextInt();
			a = new ArrayList<Edge>();
			p = new int[n+1];
			for(int i=0; i<=n; i++){
				p[i] = i;
			}
			for(int i=0; i<m; i++){
				a.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			}
		}
		Collections.sort(a, new Compare());
		
		for(Edge ed : a){
			int x = find(p,ed.s);
			int y = find(p,ed.e);
			if(x!=y){
				union(p,ed.s,ed.e);
				ans += ed.c;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int find(int p[],int x){
		if(x==p[x]){
			return x;
		}else{
			return (p[x] = find(p,p[x]));
		}
	}
	
	static void union(int p[], int x, int y){
		x = find(p,x);
		y = find(p,y);
		p[x] = y;
	}
	
}
