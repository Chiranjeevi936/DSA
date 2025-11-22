public class count_consecutive_ones_binary_array {


    public static void main(String[] args) {
        
        int [] a = {0, 1, 1,1,1,1, 1, 0, 1 , 1, 1, 1, 1};
        // int [] a ={0,0,0,1};

        int n = a.length;
        int res = 0;

        int curr =0 ;
        for(int i = 0; i < n ; i++){

            if(a[i] == 0){
                curr = 0;
            }
            else{
                curr++;
                res = Math.max(curr, res);
            }
            
            
        }

        System.out.println(res);

    }
    
}
