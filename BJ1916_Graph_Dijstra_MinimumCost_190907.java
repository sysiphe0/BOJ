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

public class BJ1916_Graph_Dijstra_MinimumCost_190907 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] dist = new int[n+1];
		for(int i=1; i<=n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		int[] vst = new int[n+1];
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		    p[s].add(new Edge(e,c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dist[start] = 0;
		
		Compare cmp = new Compare();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()){
			Edge curr = pq.poll();
			if(vst[curr.v]==1){
				continue;
			}
			vst[curr.v] = 1;
			for(Edge next : p[curr.v]){
				if(dist[next.v] > dist[curr.v]+next.c){
					dist[next.v] = dist[curr.v]+next.c;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		bw.write(dist[end]+"\n");
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int v;
		int c;
		public Edge(int v, int c){
			this.v=v;
			this.c=c;
		}
	}
	
	static class Compare implements Comparator<Edge>{
		public int compare(Edge one, Edge two){
			return Integer.compare(one.c, two.c);
		}
	}
}
