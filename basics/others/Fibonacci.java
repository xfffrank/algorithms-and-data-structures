class Fibonacci {
    static int fib1(int index) {
        // recursive
        if (index == 0) {
            return 0;
        }
        else if (index == 1) {
            return 1;
        }
        else {
            return fib1(index - 2) + fib1(index - 1);
        }
    }

    static int fib2(int index) {
        // non-recursive
        int f0 = 0, f1 = 1, f2 = 1;

        if(index == 0) {
            return f0;
        }
        else if(index == 1) {
            return f1;
        }
        else {
            for (int i = 1; i < index; i++) {
                f2 = f0 + f1;
                f0 = f1;
                f1 = f2;
            }
    
            return f2;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(Fibonacci.fib1(i));
            System.out.print(" ");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(Fibonacci.fib2(i));
            System.out.print(" ");
        }
    }
}