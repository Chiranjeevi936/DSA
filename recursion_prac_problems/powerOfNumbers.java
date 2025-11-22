public class powerOfNumbers {

    static int reverse(int n){
        int sum = 0;
        while(n > 0){
            sum = sum *10 + n%10;
            n = n/10;
        }
        return sum;
    }

    static int pow(int n, int p){
        if(p==0)
            return n;
        int temp = pow(n, p/2);
        temp = temp * temp;
        if(n%2 == 0)
            return temp;
        else
            return temp * n;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
     
        // int res = reverse(n);
        int res = pow(4, 2);

        System.out.println(res);
        
    }
    
}
