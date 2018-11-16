import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ2252_Graph_DAG_Julsewoogi {

	static int n,m,c[],sol[];
	static List<Integer> p[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 1;
		n = sc.nextInt();
		m = sc.nextInt();
		p = (List<Integer>[]) new List[n+1];
		c = new int[n+1];
		sol = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=m; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			p[s].add(e);
			c[e]++;
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++){
			if(c[i]==0) dq.add(i);
		}
		
		while(!dq.isEmpty()){
			int val = dq.pollFirst();
			System.out.print(val+" ");
			for(int i=0; i<p[val].size(); i++){
				if(--c[p[val].get(i)]==0){
					dq.add(p[val].get(i));
				}
			}
		}
		System.out.println();
	}
	
}
