public class trapping_rain_water {


    public static void main(String[] args) {
        
        int heights [] = {3, 0,1, 2,5};

        int n = heights.length;
        int res = 0;

        int lmax[] = new int[n];
        int rmax[] = new int[n];

        lmax[0] = heights[0];

        for(int i = 1; i <n ; i++){
            lmax[i] = Math.max(heights[i], lmax[i-1]);
        }

        rmax[n-1] =  heights[n-1];
        for(int i=n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i], rmax[i+1]);
        }

        for(int i =1; i< n-1 ; i++){
            res = res + ( Math.min(lmax[i], rmax[i]) - heights[i] );
        }


        System.out.println(res);



    }
    
}
