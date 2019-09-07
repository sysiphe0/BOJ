package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_Graph_Dijkstra_ShortestPath_190907 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		for(int i=1; i<=n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		
		int[] vst = new int[n+1];
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		    p[s].add(new Edge(e,c));
		}
		Compare cmp = new Compare();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			if(vst[now.to]==1) continue;
			vst[now.to] = 1;
			for(Edge next : p[now.to]){
				if(dist[next.to] > dist[now.to]+next.c){
					dist[next.to] = dist[now.to]+next.c;
					pq.add(new Edge(next.to,dist[next.to]));
				}
			}
		}
		for(int i=1; i<=n; i++){
			if(dist[i]==Integer.MAX_VALUE){
				bw.write("INF\n");
			}else{
				bw.write(dist[i]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int to;
		int c;
		public Edge(int to, int c){
			this.to=to;
			this.c=c;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
}
