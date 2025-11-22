package searchAlgorithms;

public class binarySearchLoop {

    public static void main(String[] args) {
        
        int a [] = {10,90,  20 , 30 , 40 , 50, 60, 70};
        int n = a.length;
        int search_element = 90;

        int low = 0 ; 
        int high = n-1;



        while(low<=high){
        int mid = (low+high)/2;

            if (a[mid] == search_element){
                System.out.println("found at:  " + Integer.toString(mid));
                System.exit(0);
            }

            if(search_element < a[mid]){
                high = mid-1;
            }else{
                low = mid +1;
            }


        }

        System.out.println("Not found!!");

    }

    
    
}
