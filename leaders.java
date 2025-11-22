public class leaders {

    static void check_leaders(int []a, int n){

        int curr_l = a[n-1];
        System.out.println(curr_l);
        for(int i=n-2; i>=0;i--){
            if(a[i] > curr_l){
                curr_l = a[i];
                System.out.println(curr_l);
            }
        }
    }
    public static void main(String[] args) {
        
        int[] a = {1, 10, 4, 10 , 6, 5, 2};
        int n = a.length ; 

        check_leaders(a, n);

    }
    
}
