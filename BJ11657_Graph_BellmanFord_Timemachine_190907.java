package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11657_Graph_BellmanFord_Timemachine_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dist = new int[n+1];
		ArrayList<Edge> li = new ArrayList<Edge>();
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());
			li.add(new Edge(tmp1,tmp2,tmp3));
		}
		for(int i=2; i<=n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		boolean isLoop = false;
		for(int i=1; i<=n; i++){
			for(Edge eg : li){
				if(dist[eg.s] != Integer.MAX_VALUE && dist[eg.e] > dist[eg.s]+eg.c){
					if(i==n){
						isLoop = true;
						break;
					}
					dist[eg.e] = dist[eg.s]+eg.c;
				}
			}
		}
		if(isLoop){
			bw.write("-1");
		}else{
			for(int i=2; i<=n; i++){
				if(dist[i]==Integer.MAX_VALUE){
					bw.write("-1"+"\n");
				}else{
					bw.write(dist[i]+"\n");
				}
			}
		}
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
}
