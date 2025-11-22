public class sumOfSubsets {

    static int print(int []a, int s, int n){
        if(n == 0)
            return (s==0) ? 1:0;

        return print(a, s-a[n-1],n-1) + print(a, s, n-1);
    }
    public static void main(String[] args) {
    
        // Check if any arguments were provided
        if (args.length == 0) {
            System.out.println("No command-line arguments provided.");
            return;
        }

        System.out.println("\nAttempting to convert arguments to integers:");
        int[] numbers = new int[args.length-1];
        try {
            for (int i = 0; i < args.length-1; i++) {
                numbers[i] = Integer.parseInt(args[i]);
                System.out.println("Converted argument " + i + " to int: " + numbers[i]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: One or more arguments could not be converted to integers.");
            System.err.println(e.getMessage());
        }

        int sum = Integer.parseInt(args[args.length-1]);

        System.out.println(print(numbers,sum,args.length-1));

    }
    
}
