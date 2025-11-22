package searchAlgorithms;

public class binarySearchRecursive {

    public static  int binarySearch(int [] a, int low , int high, int search_element){

        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(a[mid] == search_element){
            
            if(mid==0 || a[mid] != a[mid-1]){
                return mid;
            }else{
                return binarySearch(a, low, high-1, search_element);
            }
        }

        if(search_element < a[mid]){
            return binarySearch(a, low, mid-1, search_element);
        }else{
            return binarySearch(a, mid + 1, high, search_element);
        }

    }

    public static void main(String[] args) {
         int a[] = {10, 20, 40 , 40, 40, 40 , 50 , 60, 70};
         int n = a.length;
         int search_element = 40;

         int res = binarySearch(a, 0, n-1, search_element);

         if(res == -1){
            System.out.println("Not found!!");
         }else{
            System.out.println("Element Found at: "+ Integer.toString(res));
         }
    }
    
}
