public class Primes {
    public static void main(String[] args) {
        // Replace this statement with your code
        if (args.length == 0) {
            System.out.println("Usage: java Primes <n>");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Input must be an integer.");
            return;
        }

        if (n < 2) {
            System.out.println("Prime numbers start from 2.");
            return;
        }

        boolean[] isPrime = sieve(n);
        
        printPrimes(isPrime, n);
    }

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int p = 2;
        
        while (p * p <= n) { 
            if (isPrime[p]) {
                int i = p * p; 
                while (i <= n) {
                    isPrime[i] = false;
                    i = i + p;
                }
            }
            p++;
        }
        
        return isPrime;
    }

    public static void printPrimes(boolean[] isPrime, int n) {
        System.out.println("Prime numbers up to " + n + ":");

        int primeCount = 0;
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }
        
        int rangeSize = n; 
        
        double percentage = 0.0;
        if (rangeSize > 0) {
            percentage = (double) primeCount / rangeSize * 100;
        }
        
        System.out.printf("There are %d primes between 2 and %d (%.0f%% are primes)\n", 
                          primeCount, n, percentage);
    }
}