package array;

public class sliding_window_tech {

    public static void main(String[] args) {
        
        int a[] = {1, 4, 2 ,10 ,23, 3 ,1, 0, 20 };
        int n = a.length;

        int k = 11;
        if(n<k){
            System.out.println("There is no subarray of size "+k+" as size of whole");
            System.exit(1);
        }
        int res=0, curr=0;
        for(int i=0;i<k;i++){
            curr+=a[i];
        }
        res = curr;
        for(int i=k;i<n;i++){

            curr = curr + a[i] - a[i-k];
            if(res<curr)
                res=curr;
        }

        System.out.println(res);

    }
    
}
