public class frequencies_sorted_array {


    public static void main(String[] args) {

        int [] a = {10, 10 , 10, 30 , 40 , 60};
        int n = a.length ;

        int  i = 1;
        int freq = 1 ; 
        while(i<n){
            while( a[i] == a[i-1]){
                freq ++;
                i++;
            }
            System.out.println(String.valueOf(a[i-1]) + " : " + String.valueOf(freq));
            i++;
            freq = 1;
        }
        if(n==1 || a[n-1] !=a[n-2]){
            System.out.println(String.valueOf(a[i-1]) + " : " + String.valueOf(freq));
        }


        
    }
    
}
