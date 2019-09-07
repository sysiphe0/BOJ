package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1865_Graph_BellmanFord_WormHole_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int[] dist = new int[n+1];
			ArrayList<Edge> li = new ArrayList<Edge>();
			for(int i=1; i<=m; i++){
				st = new StringTokenizer(br.readLine());
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				int tmp3 = Integer.parseInt(st.nextToken());
				li.add(new Edge(tmp1,tmp2,tmp3));
				li.add(new Edge(tmp2,tmp1,tmp3));
			}
			for(int i=1; i<=w; i++){
				st = new StringTokenizer(br.readLine());
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				int tmp3 = Integer.parseInt(st.nextToken());
				li.add(new Edge(tmp1,tmp2,0-tmp3));
			}
			for(int i=2; i<=n; i++){
				dist[i] = Integer.MAX_VALUE;
			}
			
			boolean isPoss=false;
			for(int i=1; i<=n; i++){
				for(Edge eg : li){
					if(dist[eg.s] != Integer.MAX_VALUE && dist[eg.e] > dist[eg.s]+eg.c){
						if(i==n){
							isPoss = true;
							break;
						}
						dist[eg.e] = dist[eg.s]+eg.c;
					}
				}
				if(dist[1] < 0){
					isPoss = true;
				}
			}
			if(isPoss){
				bw.write("YES\n");
			}else{
				bw.write("NO\n");
			}
			bw.flush();
		}
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
}
