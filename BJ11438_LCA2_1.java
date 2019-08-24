import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11438_LCA2_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		List<Integer>[] a = (List<Integer>[]) new List[n+1];
		for(int i=1; i<=n; i++){
			a[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			a[t1].add(t2);
			a[t2].add(t1);
		}
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		int depth[] = new int[n+1];
		int parent[] = new int[n+1];
		int check[] = new int[n+1];
		dq.add(1);
		depth[1] = 0;
		check[1] = 1;
		while(!dq.isEmpty()){
			int tmp = dq.pollFirst();
			for(int i : a[tmp]){
				if(check[i]==1) continue;
				depth[i] = depth[tmp]+1;
				parent[i] = tmp;
				check[i] = 1;
				dq.add(i);
			}
		}
		
		int log = 1;
		while(1<<log <= n){
			log++;
		}
		log--;
		int p[][] = new int[n+1][log+1];
		for(int i=1; i<=n; i++){
			p[i][0] = parent[i];
		}
		for(int j=1; (1<<j) < n; j++){
			for(int i=1; i<=n; i++){
				if(p[i][j-1] != 0){
					p[i][j] = p[p[i][j-1]][j-1];
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(depth[x] < depth[y]){
				int tmp = x;
				x = y;
				y = tmp;
			}
			log = 1;
			while(1<<log <= depth[x]){
				log++;
			}
			log--;
			for(int j=log; j>=0; j--){
				if(depth[x]-(1<<j) >= depth[y]){
					x = p[x][j];
				}
			}
			
			if(x==y){
				bw.write(x+"");
				bw.newLine();
			}else{
				for(int j=log; j>=0; j--){
					if(p[x][j] != 0 && p[x][j] != p[y][j]){
						x = p[x][j];
						y = p[y][j];
					}
				}
				bw.write(parent[x]+"");
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
