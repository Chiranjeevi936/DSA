public class printNumbers {

    static void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        System.out.println(n-1);
        print(n-2);

    }
    
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        // printNumbers obj = new printNumbers();
        print(n);
    }
}
