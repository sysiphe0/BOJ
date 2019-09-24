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

public class BJ2211_Graph_Dijkstra_RecoverNetwork_190924 {

	static int[] vst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		int[] c = new int[n+1];
		int[] d = new int[n+1];
		for(int i=2; i<=n; i++){
			d[i] = Integer.MAX_VALUE;
		}
		vst = new int[n+1];
		
		int m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=m; i++){
			st=  new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int t3 = Integer.parseInt(st.nextToken());
			p[t1].add(new Edge(t2,t3));
			p[t2].add(new Edge(t1,t3));
		}
		
		Compare cmp = new Compare();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
		pq.add(new Edge(1,0));
		
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			if(c[now.e]==1) continue;
			c[now.e] = 1;
			for(Edge next : p[now.e]){
				if(c[next.e]==1) continue;
				if(d[next.e] > d[now.e]+next.c){
					d[next.e] = d[now.e]+next.c;
					pq.add(new Edge(next.e,d[next.e]));
					vst[next.e] = now.e;
				}
			}
		}
		
		bw.write(n-1+"\n");
		for(int i=2; i<=n; i++){
			bw.write(vst[i]+" "+i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int e;
		int c;
		public Edge(int e, int c){
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
