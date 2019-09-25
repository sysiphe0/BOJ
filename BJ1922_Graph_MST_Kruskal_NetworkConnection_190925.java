package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1922_Graph_MST_Kruskal_NetworkConnection_190925 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
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
		Collections.sort(road, new Compare());
		int ans = 0;

		for(Edge eg : road){
			int x = find(p,eg.s);
			int y = find(p,eg.e);
			if(x!=y){
				p[x]=y;
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
			return (p[x] = find(p,p[x]));
		}
	}
	
	static class Edge{
		int s,e,c;
		public Edge(int s, int e, int c){
			this.s=s;
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
