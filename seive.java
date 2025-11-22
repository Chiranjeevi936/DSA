// efficient solution
import java.util.Arrays;

public class seive {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                System.out.println(i);
                for(int j = i*i ; j<=n; j = j+i){
                    isPrime[j] = false;
                }
            }
        }

    }
    
}
