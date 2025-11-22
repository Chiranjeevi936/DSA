// class isPrime{
//     public static void main(String []args){
//         int n = Integer.parseInt(args[0]);
//         boolean res = true;
//         if(n==1 || n ==0)
//             res=false;
//         for(int i =2; i*i<=n; i++){
//             if(n%i==0){
//                 res = false;
//             }
//         }
//         System.out.println("Prime : "+String.valueOf(res));
//     }
// }



// more efficient
class isPrime{
    public static void main(String []args){
        int n = Integer.parseInt(args[0]);
        boolean res = true;
        if(n==1 || n ==0)
            res=false;
        if(n==2 || n ==3)
            res = false;
        if(n%2==0 || n%3==0)
            res=false;
        for(int i =5; i*i<=n; i = i+6){
            if(n%i==0 || n%(i+2) == 0){
                res = false;
            }
        }
        System.out.println("Prime(m) : "+String.valueOf(res));
    }
}