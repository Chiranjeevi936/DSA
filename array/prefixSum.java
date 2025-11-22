package array;

public class prefixSum {


    public static void main(String[] args) {
        

        int a [] = {2, 8, 3, 9, 6,5,4};
        int n = a.length;
        int psum[] = new int[n];
        psum[0] = a[0];

        for(int i =1; i<n;i++){
            psum[i]= psum[i-1] + a[i];
        }

        for(int i =0; i < n ; i++){
            System.out.println(psum[i]);
        }


        int l = 1;
        int r = 3;
        System.out.println("#####################");
        if(l==1){
            System.out.println(psum[r-1]);
        }else{
            System.out.println(psum[r-1] - psum[l-1]);
        }

    }
    
}
