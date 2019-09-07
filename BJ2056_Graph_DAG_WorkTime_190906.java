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

public class BJ2056_Graph_DAG_WorkTime_190906 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] ind = new int[n+1];
		int[] time = new int[n+1];
		int[] sol = new int[n+1];
		int ans = 0;
		List<Integer>[] p = (List<Integer>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			time[i] = tmp1;
			ind[i] = tmp2;
			sol[i] = tmp1;
			for(int j=0; j<ind[i]; j++){
				p[Integer.parseInt(st.nextToken())].add(i);
			}
		}
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++){
			if(ind[i]==0){
				dq.add(i);
			}
		}
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			for(int next : p[tmp]){
				sol[next] = Math.max(sol[next], sol[tmp]+time[next]);
				ind[next]--;
				if(ind[next]==0){
					dq.add(next);
				}
			}
		}
		for(int i=1; i<=n; i++){
			ans = Math.max(ans, sol[i]);
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
}
