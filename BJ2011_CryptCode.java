import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2011_CryptCode {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String code = st.nextToken();
		int p[] = new int[code.length()];
		int d[] = new int[code.length()];
		boolean breakFlag = false;
		for(int i=0; i<code.length(); i++){
			int tmp = code.charAt(i)-48;
			if(i==0 && (tmp<=0 || tmp>=10)){
				breakFlag = true;
				break;
			}else if(i!=0 && (tmp<0 || tmp>=10)){
				breakFlag = true;
				break;
			}else{
				p[i] = tmp;
			}
		}
		if(breakFlag){
			System.out.println(0);
			return;
		}
		
		d[0] = 1;
		d[1] = 1;
		if(p[0]*10+p[1] <=26) d[1] = 2;
		for(int i=2; i<code.length(); i++){
			if(p[i-1]*10+p[i] <= 26){
				d[i] = (d[i-1] + d[i-2])%1000000;
			}else{
				d[i] = d[i-1]%1000000;
			}
		}
		System.out.println(d[code.length()-1]);
	}
	
}
