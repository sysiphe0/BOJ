import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3653_SegmentTree_Movie_2 {

	static int p[], tree[], m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
			tree = new int[4*(n+m)+1];
			for(int i=1; i<=n; i++){
				p[i] = i+m;
			}
			init(1,1,n+m);
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++){
				int k = Integer.parseInt(st.nextToken());
				System.out.println(sum(1,1,n+m,1,p[k])-1);
				update(1,1,n+m,p[k],-1);
				update(1,1,n+m,m-i,1);
				p[k] = m-i;
			}
		}
	}
	
	static int init(int node, int start, int end){
		if(start==end){
			if(start>m){
				return tree[node] = 1;
			}else{
				return tree[node] = 0;
			}
		}else{
			return tree[node] = init(node*2, start, (start+end)/2) + init(node*2+1, (start+end)/2+1, end);
		}
	}
	
	static void update(int node, int start, int end, int i, int diff){
		if(i<start || i>end){
			return;
		}else{
			tree[node] += diff;
			if(start != end){
				update(node*2, start, (start+end)/2, i, diff);
				update(node*2+1, (start+end)/2+1, end, i, diff);
			}
		}
	}
	
	static int sum(int node, int start, int end, int i, int j){
		if(i>end || j<start){
			return 0;
		}else if(i<=start && end<=j){
			return tree[node];
		}else{
			return sum(node*2, start, (start+end)/2, i, j)+sum(node*2+1, (start+end)/2+1, end, i, j);
		}
	}
}
