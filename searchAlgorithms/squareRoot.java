package searchAlgorithms;

public class squareRoot {


    public static void main(String[] args) {
        
        int n = 25;

        int  low = 1;
        int ans = -1;
        int high = n;

        while(low <= high){

            int mid = (low + high)/2;

            int msq = mid * mid ; 

            if(msq > n){

                high = mid -1;
            }else{
                low = mid + 1;
                ans = mid;
            }


        }

        System.out.println(ans);


    }
    
}
