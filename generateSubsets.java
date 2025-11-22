public class generateSubsets {

    static void generate(String s , String curr, int index){
        
        if(index == s.length()){
            System.out.println(curr);
            return;
        }
        generate(s, curr, index+1);
        generate(s, curr + s.charAt(index), index+1);
    }

    public static void main(String[] args) {
        String s = args[0];

        generate(s, "", 0);
    }
    
}
