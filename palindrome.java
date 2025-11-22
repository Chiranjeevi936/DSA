public class palindrome {

    static  boolean pal(String s, int l , int r){
        if( l>=r)
            return true;
        if(s.charAt(l) != s.charAt(r))
            return  false;
        return pal(s, l+1, r-1);      
    }
    public static void main(String[] args) {
        
        if(args.length==0)
            System.out.println("Please pass at leasr one string value in cmd!!!");
        else{
            String s = args[0];
            boolean res = pal(s,0,s.length()-1);
            System.out.println(res);
        }
    }
    
}
