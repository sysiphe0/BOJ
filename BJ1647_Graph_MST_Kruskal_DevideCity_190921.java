package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1647_Graph_MST_Kruskal_DevideCity_190921 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Edge> road = new ArrayList<Edge>();
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			road.add(new Edge(t1,t2,t3));
		}
		
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = i;
		}
		
		int cnt = 0;
		int ans = 0;
		Collections.sort(road,new Compare());
		for(Edge eg : road){
			if(cnt==n-2) break;
			int x = find(p,eg.s);
			int y = find(p,eg.e);
			if(x!=y){
				union(p,eg.s,eg.e);
				cnt++;
				ans += eg.c;
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
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
	
	static int find(int[] p, int x){
		if(p[x] == x){
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
}
