package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1766_Graph_DAG_Moonjejib_190906 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] ind = new int[n+1];
		int[] sol = new int[n+1];
		List<Integer>[] p = (List<Integer>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			p[tmp1].add(tmp2);
			ind[tmp2]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=1; i<=n; i++){
			if(ind[i]==0){
				pq.add(i);
			}
		}
		
		int k=1;
		while(!pq.isEmpty()){
			int tmp = pq.poll();
			sol[k++] = tmp;
			for(int next : p[tmp]){
				ind[next]--;
				if(ind[next] == 0){
					pq.add(next);
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			bw.write(sol[i]+"");
			if(i!=n){
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();
		
	}
}
