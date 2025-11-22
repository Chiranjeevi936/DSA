public class fibonaci {

    static double fib(int n){
        
        double a[] = new double [n+1];

        a[0] = 0;
        a[1] = 1;
        for(int i =2; i<=n; i++){
            a[i] = a[i-1] + a[i-2];
            System.out.println(a[i]);

        }
        return a[n];

    }

    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        double res = fib(n);
        System.out.println(res);
    }
    
}
