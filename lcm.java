class lcm{

    public int gcd(int a , int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String []args){
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        lcm obj = new lcm();
        double gc = obj.gcd(a,b);
        double res = (a*b)/gc;
        System.out.println(res);
        
    }
}