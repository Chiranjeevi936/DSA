public class pow {

    public double calculate(int n, int p){
        if(p==1)
            return n;
        double temp = calculate(n, p/2);
        temp = temp * temp;
        if(n%2 == 0)
            return temp;
        else
            return temp * n;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);

        pow obj = new pow();

        double res = obj.calculate(n, p);
        System.out.println(res);


    }
    
}
