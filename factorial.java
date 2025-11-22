class factorial{
    public static void main(String args[]){

        int n = Integer.parseInt(args[0]);
        double r = 1;

        for(int i = 1; i<=n; i++){
            r = r*i;
        }

        System.out.println(r);
    }
}