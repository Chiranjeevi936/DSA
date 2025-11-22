package searchAlgorithms;

public class findElementInInfinityArray {

    public static int binarySearch(int [] a , int low , int high, int search_element){

        System.out.println("Binary Searching element  between  " + Integer.toString(low) + "   :   " + Integer.toString(high));

        int mid = (low+high)/2;

        if(a[mid] == search_element)
            return mid;
        
        if(a[mid] > search_element ) {
            high = mid -1 ; 
            return binarySearch(a, low , high, search_element);
        }else{
            low = mid + 1;
            return binarySearch(a, low , high, search_element);
        }

    }
    public static void main(String[] args) {

        int[] a = {10, 20, 30 , 40 , 50 , 60 , 80 , 90, 100, 150, 200, 300, 450,500, 1000};

        int search_element = 100;

        int i = 1;

        while( a[i] < search_element ){
            System.out.println("Searching element at :  " + Integer.toString(i));

            i = i * 2;
        }

        int res = binarySearch(a, i/2, i, search_element) ; 

        System.out.println(res);
        
    }
    
}
