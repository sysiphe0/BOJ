package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1197_Graph_Kruskal_MST_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] p = new int[n+1];
		ArrayList<Edge> li = new ArrayList<Edge>();
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());
			li.add(new Edge(tmp1,tmp2,tmp3));
			li.add(new Edge(tmp2,tmp1,tmp3));
		}
		for(int i=1; i<=n; i++){
			p[i] = i;
		}
		Compare cmp = new Compare();
		Collections.sort(li,cmp);
		int ans = 0;
		for(Edge eg : li){
			int x = find(p,eg.s);
			int y = find(p,eg.e);
			if(x!=y){
				union(p,x,y);
				ans += eg.c;
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	static int find(int[] p, int x){
		if(x==p[x]){
			return x;
		}else{
			return p[x] = find(p,p[x]);
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
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
}
