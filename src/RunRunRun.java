import java.util.Arrays;

public abstract class RunRunRun {
    static int curr = 7;

    static Runnable worker = ()-> {
        //noinspection InfiniteLoopStatement
        while (true) {
            int my = curr++;
            if (isGenerator(my)) print(my, period(my));
        }
    };

    public abstract void hecheln();
    
    public static void main(String[] args) {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(worker).start();
        }
    }

    static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i=2; i < sqrt; i++) if (n % i == 0) return false;
        return true;
    }

    static boolean isGenerator(int n) {
        if (!isPrime(n) || powAndMod(n - 1, n) != 1) return false;
        for (int j = 1; j < n - 1; j++) if (bigMod(bigPowSub1(j), n) == 0) return false;
        return true;
    }

    private static int bigMod(byte[] bign, int n) {
        int rest = 0;
        for (byte digit: bign) rest = (10 * rest + digit) % n;
        return rest;
    }

    private static byte[] bigPowSub1(int n) {
        byte[] result = new byte[n];
        Arrays.fill(result, (byte) 9);
        return result;
    }

    static byte[] period(int gen) {
        byte[] result = new byte[gen-1];
        int rest = 1;
        for (int i = 0; i < result.length; i++) {
            rest *= 10;
            result[i] = (byte) (rest / gen);
            rest = rest % gen;
        }
        return result;
    }

    static int powAndMod(int exp, int n) {
        int result = 1;
        for (int i = 0; i < exp; i++) result = result * 10 % n;
        return result;
    }

    static void print(int n, byte[] num) {
        StringBuilder sb = new StringBuilder(num.length).append(n).append(": ");
        for (byte b: num) sb.append(b);
        System.out.println(sb.toString());
    }
}