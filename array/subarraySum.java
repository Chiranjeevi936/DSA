package array;

public class subarraySum {

    public static void main(String[] args) {
        

        int sum=33 , curr=0;
        int s = 0;
        int a[]={1, 4 ,20, 3,11, 0, 4, 0, 0,10};

        for(int i =0; i<a.length; i++){
            
            curr+=a[i];
            while(sum<curr){
                curr -=a[s];

                s++;
            }

            if(curr ==sum){
                    System.out.println("yes");
                    System.exit(0);
            }




        }

        System.out.println("No");


    }
    
}
