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

public class BJ1922_Graph_Prim_NetworkConnection_190907 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
		}
		int[] vst = new int[n+1];
		int[] cost = new int[n+1];
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());
			p[tmp1].add(new Edge(tmp2,tmp3));
			p[tmp2].add(new Edge(tmp1,tmp3));
		}
		Compare cmp = new Compare();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1,cmp);
		pq.add(new Edge(1,0));
		int ans = 0;
		while(!pq.isEmpty()){
			Edge eg = pq.poll();
			if(vst[eg.e]==1){
				continue;
			}
			vst[eg.e] = 1;
			ans += eg.c;
			for(Edge next : p[eg.e]){
				if(vst[next.e]==0){
					pq.add(new Edge(next.e,next.c));
				}
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	static class Edge{
		int e;
		int c;
		public Edge(int e, int c){
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
