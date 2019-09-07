package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2252_Graph_DAG_Julseoogi_190906 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ind[] = new int[n+1];
		int sol[] = new int[n];
		List<Integer>[] p = (List<Integer>[]) new List[n+1];
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
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
		for(int i=1; i<=n; i++){
			if(ind[i]==0){
				dq.add(i);
			}
		}
		int k=0;
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			sol[k++] = tmp;
			for(int next : p[tmp]){
				ind[next]--;
				if(ind[next]==0){
					dq.add(next);
				}
			}
		}
		
		for(int i=0; i<sol.length; i++){
			bw.write(sol[i]+"");
			if(i<sol.length-1){
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();
	}
}
