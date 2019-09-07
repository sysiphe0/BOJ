package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1948_Graph_DAG_Imgyekyungro_190907 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] time = new int[n+1];
		int[] ind = new int[n+1];
		List<Edge>[] p = (List<Edge>[]) new List[n+1];
		List<Edge>[] rp = (List<Edge>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Edge>();
			rp[i] = new ArrayList<Edge>();
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			p[tmp1].add(new Edge(tmp2,cost,0));
			rp[tmp2].add(new Edge(tmp1,cost,0));
			ind[tmp2]++;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(start);
		
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			for(Edge eg : p[tmp]){
				time[eg.e] = Math.max(time[eg.e], time[tmp]+eg.c);
				ind[eg.e]--;
				if(ind[eg.e]==0){
					dq.add(eg.e);
				}
			}
		}
		
		dq.clear();
		dq.add(end);
		int ans = 0;
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			if(tmp==start){
				continue;
			}
			for(Edge eg : rp[tmp]){
				if((time[tmp]-eg.c)==time[eg.e] && eg.vst==0){
					ans++;
					dq.add(eg.e);
					eg.vst = 1;
				}
			}
		}
		bw.write(time[end]+"\n");
		bw.write(ans+"");
		bw.flush();
		bw.close();		
	}
	
	static class Edge{
		int e;
		int c;
		int vst;
		public Edge(int e, int c, int vst){
			this.e = e;
			this.c = c;
			this.vst = vst;
		}
	}
}
