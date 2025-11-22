public class ropeCutting {

    static int maxpieces(int n, int a, int b, int c){

        if(n==0){
            return n;
        }
        if(n<0){
            return -1;
        }

        int res = Math.max(
                    maxpieces(n-a, a, b, c), 
                    Math.max(maxpieces(n-b, a, b, c), maxpieces(n-c, a, b, c)));
        if(res==-1){
            return -1;
        }
        return res+1;

    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        int c = Integer.parseInt(args[3]);
        if(a<=0 || b<=0 || c<=0)
            System.out.println("Please enter valida (>0) rope length!!");
        else
            System.out.println(maxpieces(n, a, b, c));
    }
}
