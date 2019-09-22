package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ16398_Graph_MST_Kruskal_Planet_190922 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = i;
		}
		
		ArrayList<Edge> road = new ArrayList<Edge>();
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				int tmp = Integer.parseInt(st.nextToken());
				if(i==j) continue;
				road.add(new Edge(i,j,tmp));
			}
		}
		Collections.sort(road, new Compare());
		long ans = 0;
		
		for(Edge now : road){
			int x = find(p,now.s);
			int y = find(p,now.e);
			if(x!=y){
				ans += now.c;
				p[x] = y;
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
		int s;
		int e;
		int c;
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
