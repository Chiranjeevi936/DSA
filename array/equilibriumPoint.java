package array;

public class equilibriumPoint {


    public static void main(String[] args) {
        int a[] = {3 , 4, 8, -9, 20 , 6 };
        // int a [] = {4 , 2 ,-2};

        int n = a.length;

        for(int i= 0 ; i <n; i++){
            System.out.println("Checking: " + Integer.toString(a[i]));

            int l = i-1;
            System.out.println("    Value of l : " + Integer.toString(l));
            int r = i +1;
            System.out.println("    Value of r : " + Integer.toString(r));
            int rsum = 0;
            int lsum = 0;
            while(l >= 0){
                System.out.println("        Value of l : " + Integer.toString(l));
                lsum += a[l];
                l--;
                System.out.println("        Value of lsum : " + Integer.toString(lsum));

            }

            while(r < n ){
                System.out.println("        Value of r : " + Integer.toString(r));
                rsum += a[r];
                r ++;
                System.out.println("        Value of rsum : " + Integer.toString(rsum));
            }

            if(lsum == rsum){
                System.out.println("yes " + Integer.toString(a[i]));
                System.exit(1);
            }
        }
    }
    
}
