package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1717_Graph_MST_Kruskal_CheckSet_190921 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Edge> road = new ArrayList<Edge>();
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = i;
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			if(t1==0){
				union(p,t2,t3);
			}else{
				int x = find(p,t2);
				int y = find(p,t3);
				if(x==y){
					bw.write("YES\n");
				}else{
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
	
	static int find(int[] p, int x){
		if(x==p[x]){
			return x;
		}else{
			return (p[x] = find(p,p[x]));
		}
	}
	
	static void union(int[] p, int x, int y){
		x = find(p,x);
		y = find(p,y);
		p[x] = y;
	}
	
	static class Edge{
		int s;
		int e;
		int c;
		public Edge(int s, int e, int c){
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}
}
