public class toh {
    static void move(int n, char A, char B, char C){
        if(n==1){
            System.out.println("move disk 1 : "+ A + " to "+C);
            return;
        }
        move(n-1, A, C,B);
        System.out.println("move disk " + n + " : " + A + " to "+C);
        move(n-1,B,A,C);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        move(n,'A','B','C');
    }
}
