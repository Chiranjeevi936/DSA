public class navyatha{


    public void sum(int a, int b){

        System.out.println(a+b);
    }

    public void sum(int a, int b, int c){
        System.out.println(a+b+c);
    }
    
    public void sum(String a, String b, int c){

        System.out.println(a+b+c);
    }

    public static void main(String [] args){

        int a = Integer.valueOf(args[0]);
        int b = Integer.valueOf(args[1]);
        int c = Integer.valueOf(args[2]);


        navyatha obj = new navyatha();

        obj.sum(a,b);
        obj.sum(a,b,c);
        obj.sum("x", "y", c);



    }

}