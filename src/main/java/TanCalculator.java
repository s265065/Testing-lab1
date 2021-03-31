public class TanCalculator {

    private static final int AMOUNT = 30;
    private static final double EPS = 1E-10;

    public Double calculateTan(Double x) {
        double c = cos(x);

        if (Math.abs(c) < EPS) {
            return Double.POSITIVE_INFINITY;
        }

        return sin(x) / c;
    }

    private static double cos(double x) {
        double sum = 0;

        for (int i = 0; i < AMOUNT; i++) {
            sum += minusOnePow(i) * prod(x, 2 * i);
        }

        return sum;
    }

    private static double sin(double x) {
        double sum = 0;

        for (int i = 0; i < AMOUNT; i++) {
            sum += minusOnePow(i) * prod(x, 2 * i + 1);
        }

        return sum;
    }

    private static int minusOnePow(int n) {
        return 1 - (n % 2) * 2;
    }

    private static double prod(double x, int n) {
        double accum = 1;

        for (int i = 1; i <= n; i++) {
            accum *= x / i;
        }

        return accum;
    }
}