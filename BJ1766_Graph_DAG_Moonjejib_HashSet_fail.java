import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BJ1766_Graph_DAG_Moonjejib_HashSet_fail {

	static int n,m,c[];
	static List<Integer> p[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 1;
		n = sc.nextInt();
		m = sc.nextInt();
		p = (List<Integer>[]) new List[n+1];
		c = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=m; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			p[s].add(e);
			c[e]++;
		}
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=1; i<=n; i++){
			if(c[i]==0) hs.add(i);
		}

		Iterator<Integer> it;
		while(!hs.isEmpty()){
			it = hs.iterator();
			int val = it.next();
			hs.remove(val);
			System.out.print(val+" ");
			for(int i=0; i<p[val].size(); i++){
				if(--c[p[val].get(i)]==0){
					hs.add(p[val].get(i));
				}
			}
		}
		System.out.println();
	}
	
}
