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

public class BJ1504_Graph_Dijkstra_SpecialMinimumPath_190907 {
	static PriorityQueue<Edge> pq;
	static int[] vst, dist;
	static List<Edge>[] p;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		int m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());
			p[tmp1].add(new Edge(tmp2,tmp3));
			p[tmp2].add(new Edge(tmp1,tmp3));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		Compare cmp = new Compare();
		pq = new PriorityQueue<Edge>(1,cmp);
		int sol1_v1 = dik(1,v1);
		int sol1_v2 = dik(v1,v2);
		int sol1_n = dik(v2,n);
		int sol1 = 0;
		if(sol1_v1==Integer.MAX_VALUE || sol1_v2==Integer.MAX_VALUE || sol1_n==Integer.MAX_VALUE){
			sol1 = Integer.MAX_VALUE;
		}else{
			sol1 = sol1_v1 + sol1_v2 + sol1_n;
		}
		int sol2_v2 = dik(1,v2);
		int sol2_v1 = dik(v2,v1);
		int sol2_n = dik(v1,n);
		int sol2 = 0;
		if(sol2_v2==Integer.MAX_VALUE || sol2_v1==Integer.MAX_VALUE || sol2_n==Integer.MAX_VALUE){
			sol2 = Integer.MAX_VALUE;
		}else{
			sol2 = sol2_v2 + sol2_v1 + sol2_n;
		}
		int sol = Math.min(sol1, sol2);
		if(sol==Integer.MAX_VALUE){
			bw.write("-1");
		}else{
			bw.write(sol+"");
		}
		bw.flush();
		bw.close();
	}
	
	static int dik(int start, int end){
		vst = new int[n+1];
		dist = new int[n+1];
		for(int i=1; i<=n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.clear();
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
		return dist[end];
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
