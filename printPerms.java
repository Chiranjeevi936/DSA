public class printPerms {

    static void print(String s, int n, String curr){
        if(n==0){
            System.out.println(curr);
            return;
        }
        if(curr.contains( String.valueOf(s.charAt(n-1)))){
            return;
        }
        print(s,n-1,s.charAt(n-1)+curr);
        print(s,n-1, curr+s.charAt(n-1));

    }
    
    public static void main(String[] args) {
        print("ABC",3,"");
    }
}
