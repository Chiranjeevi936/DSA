public class longest_even_odd_array {

    public static void main(String[] args) {
        

        // int [] a = {5, 10, 20, 6, 3, 8, 7, 0};
        int a[] = {4,0  };
        int n = a.length;

        int res = 1;

        int curr = 1;

        for(int i =1; i<n ; i++){

            if( ( a[i] %2==0 && a[i-1]%2!=0) ||  a[i] %2!=0 && a[i-1]%2==0){
                curr ++;
            }
            else{
                curr = 1;
            }
            res = Math.max(curr, res);

        }

        System.out.println(res);
    }
    
}
