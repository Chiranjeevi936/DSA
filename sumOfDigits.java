public class sumOfDigits {

    static int sum(int n){
        if(n<=9)
            return 0;
        return n%10 + sum(n/10);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int res = sum(n);
        System.out.println(res);
    }
}
