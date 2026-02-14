public class prac {

    public static void print(int n ){

     if(n == 0){
        return;
     }
     print(n-1);
     System.out.println(n);
    }

    public static int sum(int n ){
        if(n<=0){
            return 0;
        }
        return n + sum(n-1);
    }

    public static boolean isPalindrome(String s, int l , int r){
        if(l > r){
            return true;
        }
        if(s.charAt(l) != s.charAt(r))
            return false;
        else
            return isPalindrome(s,l+1, r-1);
    }

    public static int sumOfDigits(int n ){
        if(n==0){
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }


    public static int ropeCuttingProblem(int a, int b, int c, int len){
        if(len == 0){
            return 0;
        }else if(len < 0){
            return -1;
        }
        int res = Math.max( 
                                ropeCuttingProblem(a, b, c, len-a), 
                                    Math.max(   
                                        ropeCuttingProblem(a, b, c, len-b),
                                         ropeCuttingProblem(a, b, c, len-c)
                                        )
                                );
        return res == -1 ? -1 : res + 1;
        
    }


    public static void  subSetsOfString(String s , int i , String set){
        if(i == s.length()){
            System.out.println(set);
            return;
        }
        subSetsOfString(s, i + 1 , set);
        subSetsOfString(s, i+1, set  + s.charAt(i));
    }


    public static void tow(String s , String d , String temp , int n ){
        if(n==1){
            System.out.println("Move disk 1 from " + s + " to " + d);
            return;
        }
        tow(s,temp,d, n-1);
        System.out.println("Move disk " + String.valueOf(n) + " from " + s + " to " + d);
        tow(temp, d, s , n-1);
    }

    public static int sumOfSubsetsOfsum(int[] a , int s, int n){
        if(n == 0)
            return s==0? 1 : 0 ;
        return sumOfSubsetsOfsum(a, s - a[n-1], n-1) + sumOfSubsetsOfsum(a, s, n-1);
    }

    public static String swap(String s , int i , int j){
        char [] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return  String.valueOf(charArray);

    }

    public static void permute(String s, int i ){
        if(i == s.length() - 1)
            System.out.println(s);
        for(int j = i; j < s.length() ; j++){
            s = swap(s, i, j);
            permute(s, i+1);
            s = swap(s, i, j);
        }
    }


    public static int secondLargetInArray(){
        int [] a = {12, 12 ,12, 12  ,2};
        int n = a.length;
        int res = -1;
        int largset = -1;
        for(int i=0; i < n ; i++){
            if(largset < a[i]){
                res = largset;
                largset = a[i];
            }else if(largset > a[i]){
                if(res < a[i]){
                    res  = a[i];
                }
            }
        }
        return res;
    }


    public static void checkIfArraySorted(){
        int a[] = {90, 78, 60, 9,2, 100};
        int n = a.length;
        int aof = 1;
        int dof = 1;
        boolean isAscend = true;
        boolean isDescend = true;
        while((isAscend || isDescend) && (aof < n && dof < n)){
            if( a[aof] < a[aof -1 ])
                isAscend = false;
            if(a[dof] > a[dof-1])
                isDescend = false;

            aof++;
            dof++;
        }
        System.out.println("is ascending: " + String.valueOf(isAscend));
        System.out.println("is descending: " + String.valueOf(isDescend));
    }

    public static void reverseArray(){
        int [] a = {3, 4, 5 ,6 , 8, 9};                
        System.out.println("Before Reverse:- ");
        for(int i = 0; i < a.length; i++){
            System.out.print(String.valueOf(a[i])+ " ");
        }
        System.out.println();
        int r = a.length -1;
        int l = 0;
        while(l<r){
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        System.out.println("After Reverse:- ");
        for(int i = 0; i < a.length; i++){
            System.out.print(String.valueOf(a[i])+ " ");
        }
        System.out.println();        
    }


    public static void  removeDuplicatesFromSortedArray(){

        int a [] = {3, 3, 4, 5, 6, 6, 7 , 8};
        int n = a.length;

        int l =0;
        int r = 0;

        while(r<n){


            if( a[l] == a[r]){
                r++;
                continue;
            }
            l++;
            a[l] = a[r];
            r++;


        }

        for(int i=0; i <= l; i++){
            System.out.println(a[i]);
        }

    }

    public static void main(String[] args) {
        

       



    removeDuplicatesFromSortedArray();
        
       




    }
    
}
