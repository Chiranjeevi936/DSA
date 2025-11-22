class gcd{

    public int calculate(int a , int b){
        if (b == 0){
            return a;
        }

        return calculate(b, a%b);
    }
    public static void main(String []args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        gcd obj = new gcd();
        int ret = obj.calculate(a,b);

        System.out.println(ret);
    }
}